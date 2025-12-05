import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] match;
	static boolean[] visited;

	private static boolean dfs(int u) {
		for(int v : adj[u]) {
			if(visited[v]) continue;
			visited[v] = true;

			if(match[v] == 0 || dfs(match[v])) {
				match[v] = u;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[2*N+1];
		for(int i = 1; i <= 2*N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				adj[i].add(num);
				adj[i+N].add(num); //정점 분할 방식
			}
		}

		int totalMatching = 0;
		match = new int[M+1];
		for(int i = 1; i <= 2*N; i++) {
			visited = new boolean[M+1];

			if(dfs(i)) {
				totalMatching++;
			}
		}

		System.out.println(totalMatching);
	}
}
