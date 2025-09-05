import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 등산로 조성
 * 성능: 
 * @author 서울_7반_정정교
 *
 */
public class Solution {

	static int N, K, answer;
	static int[][] map, newMap;
	static boolean[][] visited;
	static int maxHeight;
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			//#1. 지도 정보 입력
			map = new int[N][N];
			maxHeight = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			answer = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == maxHeight) { // 조건 1. 등산로는 가장 높은 곳에서 부터 시작한다.
						dfs(i, j, 1, false);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int r, int c, int len, boolean isUsed) {
		answer = Math.max(answer, len);
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			//그냥 갈 수 있는 경우
			if(map[nr][nc] < map[r][c]) {
				dfs(nr, nc, len+1, isUsed);
			} else {
				if(!isUsed) {
					for(int k = 1; k <= K; k++) {
						if(map[nr][nc]-k < map[r][c]) { //깎으면 갈 수 있음
							map[nr][nc] -= k;
							dfs(nr, nc, len+1, true);
							map[nr][nc] += k;
							break;
						}
					}
				}
			}
		}
		
		visited[r][c] = false;
	}
}
