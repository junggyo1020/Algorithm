import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L, R, C;
	static char[][][] map;
	static int[][][] v;
	static int sx, sy, sz, ex, ey, ez;
	static int[][][] visited;

	static final int[] dz = {0, 0, 0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0, 0, 0};
	static final int[] dx = {0, 0, 1, -1, 0, 0};

	static class Point {
		int z, y, x;
		Point(int z, int y, int x){
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) break;

			map = new char[L][R][C];
			visited = new int[L][R][C];

			for (int d = 0; d < L; d++) {
				for (int i = 0; i < R; i++) {
					String str = br.readLine();
					for (int j = 0; j < C; j++) {
						map[d][i][j] = str.charAt(j);
						if (map[d][i][j] == 'S') {
							sz = d;
							sy = i;
							sx = j;
						}
						if (map[d][i][j] == 'E') {
							ez = d;
							ey = i;
							ex = j;
						}
					}
				}
				br.readLine();
			}

			bfs(sz, sy, sx);
		}
	}

	private static void bfs(int z, int y, int x){
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(z, y, x));
		visited[z][y][x] = 1;

		while(!q.isEmpty()){
			Point cur = q.poll();
			int cz = cur.z;
			int cy = cur.y;
			int cx = cur.x;

			if(cz == ez && cy == ey && cx == ex) {
				System.out.println("Escaped in " + (visited[ez][ey][ex] - 1) + " minute(s).");
				return;
			}
			for(int d = 0; d < 6; d++){
				int nz = cz + dz[d];
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if(nz < 0 || nz >= L || ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
				if(visited[nz][ny][nx] != 0 || map[nz][ny][nx] == '#') continue;
				visited[nz][ny][nx] = visited[cz][cy][cx] + 1;
				q.offer(new Point(nz, ny, nx));
			}
		}

		System.out.println("Trapped!");
	}
}
