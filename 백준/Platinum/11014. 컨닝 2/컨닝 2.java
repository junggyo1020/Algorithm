import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static final int[] dy = {-1, -1, 0, 0, 1, 1};
	static final int[] dx = {-1, 1, -1, 1, -1, 1};
	static ArrayList<Integer>[] adj;
	static int[] match;
	static boolean[] visited;

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
		int C = Integer.parseInt(br.readLine());
		for(int c = 1; c <= C; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			//지도 저장
			map = new char[N][M];
			int validCnt = 0;
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '.') {
						validCnt++;
					}
				}
			}

			//간선 리스트 초기화 (i*M +j) 로 1차원화 하기(중요)
			adj = new ArrayList[N*M];
			for(int i = 0; i < N*M; i++) {
				adj[i] = new ArrayList<>();
			}

			//간선 정리
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j+=2) {
					if(map[i][j] == 'x') continue;

					int u = i * M + j;
					for(int k = 0; k < 6; k++) {
						int ni = i + dy[k];
						int nj = j + dx[k];

						if(ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == '.') {
							int v = ni * M + nj;
							adj[u].add(v);
						}
					}
				}
			}

			int totalMatching = 0;
			match = new int[N*M];
			Arrays.fill(match, -1);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j+=2) {
					if(map[i][j] == '.') {
						int u = i * M + j;
						visited = new boolean[N*M];
						if(dfs(u)) {
							totalMatching++;
						}
					}
				}
			}

			System.out.println(validCnt - totalMatching);
		}
	}
}
