import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static final int SIZE = 16;
	static final int TEST_CASE = 10;
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};

	static int[][] map;
	static int sy, sx;

	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= TEST_CASE; t++) {
			br.readLine();
			map = new int[SIZE][SIZE];

			for (int i = 0; i < SIZE; i++) {
				String str = br.readLine();
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						sy = i;
						sx = j;
					}
				}
			}

			System.out.println("#" + t + " " + BFS(sy, sx));
		}
	}

	private static int BFS(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(y, x));
		boolean[][] visited = new boolean[SIZE][SIZE];
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if(map[cur.y][cur.x] == 3) {
				return 1;
			}

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if(ny<0 || ny>=SIZE || nx<0 || nx>=SIZE) continue;
				if(visited[ny][nx] || map[ny][nx] == 1) continue;

				q.offer(new Point(ny, nx));
				visited[ny][nx] = true;
			}
		}

		return 0;
	}
}
