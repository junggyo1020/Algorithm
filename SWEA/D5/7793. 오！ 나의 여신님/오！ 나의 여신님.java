import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 오 나의 여신님
 * 성능: 
 * @author 서울_7반_정정교
 *
 */
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, sy, sx, ey, ex;
	static char[][] map;
	static boolean[][] sVisited; //수연 방문 체크 배열
	static boolean[][] dVisited; //악마 방문 체크 배열
	
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//#1. 지도 정보 입력
			map = new char[N][M];
			sVisited = new boolean[N][M];
			dVisited = new boolean[N][M];
			Queue<Point> dq = new ArrayDeque<>();
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					char ch = str.charAt(j);
					map[i][j] = ch;
					if(ch == 'S') {
						sy = i;
						sx = j;
					}
					if(ch == '*') {
						dq.offer(new Point(i, j));
						dVisited[i][j] = true;
					}
				}
			}
			
			//#2. 수연 이동
			Queue<Point> q = new ArrayDeque<>();
			q.offer(new Point(sy, sx));
			sVisited[sy][sx] = true;
			
			boolean flag = false; //길을 찾았는지 여부
			int time = 0;
			
			loop:
			while(!q.isEmpty()) {
				
				//악마 이동
				int dsize = dq.size();
				for(int i = 0; i < dsize; i++) {
					Point cur = dq.poll();
					int y = cur.y;
					int x = cur.x;
					
					for(int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						
						if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
						if(map[ny][nx] == '.') {
							map[ny][nx] = '*';
							dq.offer(new Point(ny, nx));
						}
					}
				}
				
				//수연 이동
				int size= q.size();
				for(int i = 0; i < size; i++) {
					Point cur = q.poll();
					int y = cur.y;
					int x = cur.x;
					
					if(map[y][x] == 'D') {
						sb.append("#").append(t).append(" ").append(time).append("\n");
						flag = true;
						break loop;
					}
					
					for(int d = 0; d < 4; d++) {
						int ny = y + dy[d];
						int nx = x + dx[d];
						
						if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
						if(sVisited[ny][nx] || map[ny][nx]=='*' || map[ny][nx]=='X') continue;
						sVisited[ny][nx] = true;
						q.offer(new Point(ny, nx));
					}
				}
				
				time++;
			}// end while
			
			if(!flag) sb.append("#").append(t).append(" ").append("GAME OVER").append("\n");
			
		} //end testCase
		System.out.println(sb);
	} //end main
}
