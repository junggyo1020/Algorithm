import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static int V, E;
	static ArrayList<Integer>[] adj;
	static int[] numbers;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int t = 0; t < K; t++) {
			flag = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); //정점 개수
			E = Integer.parseInt(st.nextToken()); //간선 개수

			adj = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}

			//TODO : 간선 정보 입력 받기
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}

			//TODO : 이분 그래프 탐색
			numbers = new int[V+1];
			for(int i = 1; i <= V; i++) {
				if(numbers[i] == 0) {
					numbers[i] = 1;
					dfs(i);
				}
				if(flag) break;
			}

			System.out.println(flag ? "NO" : "YES");
		}
	}

	private static void dfs(int cur) {
		for (int next : adj[cur]) {
			if(numbers[next] != 0) { //이미 방문함
				if(numbers[next] == numbers[cur]) {
					flag = true;
					return;
				}
			} else {
				numbers[next] = numbers[cur] * -1;
				dfs(next);
			}
		}
	}
}
