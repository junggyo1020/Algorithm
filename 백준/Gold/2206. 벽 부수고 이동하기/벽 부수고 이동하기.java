import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, idx;
	static int[][] map;
	static int[][][] dist;
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	static final int INF = 987654321;

	static class Point {
		int y, x, destroyed;
		Point(int y, int x, int destroyed) {
			this.y = y;
			this.x = x;
			this.destroyed = destroyed;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M][2];
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0, 0));
		dist[0][0][0] = 1;

		while(!q.isEmpty()) {
			Point cur = q.poll();

			//도착지점에 도착하면 종료
			if(cur.y == N-1 && cur.x == M-1) {
				System.out.println(dist[cur.y][cur.x][cur.destroyed]);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				//범위체크
				if(ny<0 || nx<0 || ny>=N || nx>= M) continue;

				//벽이 아닌 경우
				if(map[ny][nx] == 0) {
					if(dist[ny][nx][cur.destroyed] == 0) {
						dist[ny][nx][cur.destroyed] = dist[cur.y][cur.x][cur.destroyed] + 1;
						q.offer(new Point(ny, nx, cur.destroyed));
					}
				}

				//벽이지만 부수고 넣는 경우
				else {
					if(cur.destroyed == 0 && dist[ny][nx][1] == 0) {
						dist[ny][nx][1] = dist[cur.y][cur.x][0] + 1;
						q.offer(new Point(ny, nx, 1));
					}
				}
			}
		}
		System.out.println("-1");
	}
}
