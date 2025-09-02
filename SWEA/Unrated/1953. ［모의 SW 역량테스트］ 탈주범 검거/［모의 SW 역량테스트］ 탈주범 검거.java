import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1953. 탈주범 검거
 * 성능:
 * @author 서울_7반_정정교
 *
 * 터널의 종류에 따라 탐색의 방향이 달라지는 유형
 */
public class Solution {
	
	static int N, M, R, C, L;
	static int[][] map;
	static int[][] visited;
	
	//터널 타입별 탐색 방향 저장
	static boolean[][] type = {
			{false, false, false, false}, // 0번 타입 (없음)
		    {true, true, true, true},   // 1번 타입 (상하좌우)
		    {true, true, false, false},  // 2번 타입 (상하)
		    {false, false, true, true},  // 3번 타입 (좌우)
		    {true, false, false, true},  // 4번 타입 (상우)
		    {false, true, false, true},  // 5번 타입 (하우)
		    {false, true, true, false},  // 6번 타입 (하좌)
		    {true, false, true, false}   // 7번 타입 (상좌)
	};
	
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //터널 세로크기 (최대 50)
			M = Integer.parseInt(st.nextToken()); //터널 가로크기 (최대 50)
			R = Integer.parseInt(st.nextToken()); //시작 행 번호 (최대 49) 0-based index
			C = Integer.parseInt(st.nextToken()); //시작 열 번호 (최대 49) 0-based index
			L = Integer.parseInt(st.nextToken()); //탈추 후 소요된 시간(1부터 시작)
			
			//1. 지도 정보 입력
			map = new int[N][M];
			visited = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//2. 시작위치부터 bfs 시작
			Queue<Point> q = new ArrayDeque<>();
			q.offer(new Point(R, C));
			visited[R][C] = 1;
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				int r = cur.y;
				int c = cur.x;
				
				if(visited[r][c]==L) break;
				
				for(int d = 0; d < 4; d++) {
					if (!type[map[r][c]][d]) continue;
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0 || map[nr][nc] == 0) {
			            continue;
			        }
					
					int nextType = map[nr][nc];
			        int oppositeDirection = (d % 2 == 0) ? d + 1 : d - 1;
			        
			        if (type[nextType][oppositeDirection]) {
			            visited[nr][nc] = visited[r][c] + 1;
			            q.offer(new Point(nr, nc));
			        }
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visited[i][j]>0) {
						cnt++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
