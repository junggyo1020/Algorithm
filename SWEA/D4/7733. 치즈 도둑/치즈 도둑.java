import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	/**
	 * [D4] 치즈 도둑
	 * - 치즈의 맛 정도를 배열로 저장(최대 100*100)
	 * - 100일 동안 반복
	 * - 치즈 덩어리를 구하기 위한 상태 배열 선언 (0: 안먹음, 1: 먹음)
	 * - N일에 맛 정도가 N인 치즈 상태 1로 변경
	 * - 치즈 덩어리 개수 구하기(DFS) : cheezeCnt
	 * - 최대 치즈 덩어리 개수 갱신 : maxCheezeCnt
	 * - 최대 치즈 덩어리 개수 출력
	 */
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, maxCheezeCnt, maxTaste;
	static int[][] cheeze;
	static boolean[][] visited;
	static int[][] status;
	
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			//#1
			N = Integer.parseInt(br.readLine());
			cheeze = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cheeze[i][j] = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(maxTaste, cheeze[i][j]);
				}
			}
			
			maxCheezeCnt = 0;
			
			//#2
			status = new int[N][N];
			for(int d = 0; d <= maxTaste; d++) {
				//#3
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						//#4
						if(cheeze[i][j] == d) status[i][j] = 1;
					}
				}
				
				//#5
				visited = new boolean[N][N];
				int cnt = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						//안먹었고, 방문안한것
						if(status[i][j] == 0 && !visited[i][j]) {
							//#6
							dfs(i, j);
							cnt++;
						}
					}
				}
				
				//#7
				maxCheezeCnt = Math.max(maxCheezeCnt, cnt);
			}
			sb.append("#").append(t).append(" ").append(maxCheezeCnt).append("\n");
		}
		System.out.println(sb);
	}
	
	//#6
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
			if(status[ny][nx] == 0 && !visited[ny][nx]) {
				dfs(ny, nx);
			}
		}
	}
}
