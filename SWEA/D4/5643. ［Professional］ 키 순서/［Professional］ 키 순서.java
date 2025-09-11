import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자신보다 키가 큰 학생들 따라가며 탐색 - DFS, BFS
 * 자신보다 키가 작은 학생들 따라가며 탐색 - DFS, BFS
 */
public class Solution {

	static int N, M;
	static int[][] adj, radj;
	static int count; // 자신보다 키가 크거나 작은 학생 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1]; // 1번부터
			radj = new int[N+1][N+1];

			for(int i = 0; i < M; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				radj[b][a] = adj[a][b] = 1; // a보다 b가 키가 크다
			}

			int ans = 0;
			for(int i = 1; i <= N; i++){
				count = 0;
				boolean[] visited = new boolean[N+1];
				dfs(i, adj, visited); // 수행하고 나면 count에는 나보다 큰 학생 수가 저장
				dfs(i, radj, visited); // 수행하고 나면 count에는 나보다 작은 학생 수까지 누적되어 저장
				if(count == N-1) {
					++ans;
				}
			}

			sb.append("#" + t + " " + ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		for(int i = 1; i <= N; i++){
			if(adj[cur][i] == 1 && !visited[i]){
				++count;
				dfs(i, adj, visited);
			}
		}
	}
}
