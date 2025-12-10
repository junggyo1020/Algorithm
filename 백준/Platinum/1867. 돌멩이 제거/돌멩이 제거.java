import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static ArrayList<Integer>[] adj;
	static int[] match;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}

		int totalMatching = 0;
		match = new int[N+1];
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			if(dfs(i)) {
				totalMatching++;
			}
		}

		System.out.println(totalMatching);
	}

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
}
