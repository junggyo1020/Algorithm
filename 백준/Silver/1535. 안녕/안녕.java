import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] L, J;
	static boolean[] visited;
	static int maxHappiness = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		J = new int[N];
		visited = new boolean[N];

		//L
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}

		//J
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}

		//아이디어 1. 시간복잡도 적으니, 모든 경우의 수를 탐색해보자.
		//선택하거나? 선택하지 않거나, => 부분집합으로 풀면 되곘다.
		dfs(0, visited);
		System.out.println(maxHappiness);
	}

	private static void dfs(int cnt, boolean[] visited) {
		if(cnt == N) {
			int health = 100;
			int happiness = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					health -= L[i];
					happiness += J[i];

					if(health <= 0) return;
				}
				//최대 기쁨 갱신
				maxHappiness = Math.max(maxHappiness, happiness);
			}
			return;
		}

		//재귀(부분집합)
		visited[cnt] = true;
		dfs(cnt + 1, visited);
		visited[cnt] = false;
		dfs(cnt + 1, visited);
	}
}
