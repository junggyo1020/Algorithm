import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static boolean[] isPrime;
	static ArrayList<Integer>[] adj; 
	static ArrayList<Integer> listA, listB;
	static int[] match;
	static boolean[] visited;

	private static void sieve() {
		isPrime = new boolean[2001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for(int i = 2; i * i <= 2000; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j <= 2000; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
	
	private static boolean dfs(int u) {
		for(int v : adj[u]) {
			if(visited[v]) continue;
			visited[v] = true;
			
			if(match[v] == -1 || dfs(match[v])) {
				match[v] = u;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		// 1. 소수 판별 배열 만들기
		sieve();

		// 2. 그룹 나누기 (첫 번째 수와 홀짝이 같으면 A, 다르면 B)
		listA = new ArrayList<>();
		listB = new ArrayList<>();

		boolean firstIsOdd = numbers[0] % 2 != 0;

		for(int i = 1; i < N; i++) {
			if((numbers[i] % 2 != 0) == firstIsOdd) {
				listA.add(i); // A그룹 (0번과 같은 편)
			} else {
				listB.add(i); // B그룹 (0번과 다른 편 - 짝꿍 후보들)
			}
		}

		// A그룹(0번 포함)과 B그룹의 크기가 다르면 전원 짝짓기 불가능
		if(listA.size() + 1 != listB.size()) {
			System.out.println(-1);
			return;
		}

		// 3. 그래프 간선 연결 (인덱스 기준)
		adj = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		// A그룹(0번 포함) <-> B그룹 연결
		// 0번도 연결해줘야 함!
		for(int b : listB) {
			if(isPrime[numbers[0] + numbers[b]]) {
				adj[0].add(b);
			}
		}

		// 나머지 A그룹 멤버들도 B그룹과 연결
		for(int a : listA) {
			for(int b : listB) {
				if(isPrime[numbers[a] + numbers[b]]) {
					adj[a].add(b);
				}
			}
		}

		// 4. 핵심 로직: 0번이랑 짝지을 수 있는 B그룹 애들을 하나씩 시도
		ArrayList<Integer> result = new ArrayList<>();

		for(int b : listB) {
			// 0번과 b번이 짝이 될 수 있다면? (합이 소수라면)
			if(isPrime[numbers[0] + numbers[b]]) {

				// --- 시뮬레이션 시작 ---

				// 매칭 배열 초기화 (-1은 짝 없음 의미)
				match = new int[N];
				Arrays.fill(match, -1);

				// [강제 매칭] 0번과 b번을 짝지어 버림
				match[b] = 0;

				// 현재 매칭 된 커플 수 = 1쌍 (0-b)
				int count = 1;

				// 나머지 A그룹 멤버들(listA)을 짝지어 주기
				for(int a : listA) {
					visited = new boolean[N];

					// [중요] b번은 이미 0번 꺼니까 아무도 건드리면 안 됨!
					// visited[b]를 true로 해서 탐색 못 하게 막음
					visited[b] = true;

					if(dfs(a)) {
						count++;
					}
				}

				// 모든 커플이 탄생했으면 (총 N/2 쌍)
				if(count == N / 2) {
					result.add(numbers[b]); // b의 '실제 값'을 정답 리스트에 추가
				}
			}
		}

		// 5. 출력
		if(result.isEmpty()) {
			System.out.println(-1);
		} else {
			// 오름차순 정렬
			Collections.sort(result);
			StringBuilder sb = new StringBuilder();
			for(int val : result) {
				sb.append(val).append(" ");
			}
			System.out.println(sb);
		}
	}
}