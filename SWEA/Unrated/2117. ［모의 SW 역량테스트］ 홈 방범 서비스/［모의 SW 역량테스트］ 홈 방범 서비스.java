import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1 ,1};
	static int N, M, K;
	static int res;
	static int[][] map;
	static int[] cost;
	static boolean[][] visited;

	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// k <= 40이므로 미리 운영비용 계산
			cost = new int[41];
			for (int i = 1; i <= 40; i++) {
				cost[i] = i*i + (i-1)*(i-1);
			}

			//집이 있는 경우에만 탐색 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}

			sb.append("#").append(t).append(" ").append(res).append("\n");
		} //end testcase
		System.out.println(sb);
	} //end main

	private static void bfs(int y, int x) {
		Deque<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];

		q.offer(new Point(y, x));
		visited[y][x] = true;

		K = 1;
		int cnt = map[y][x]; //홈 방범 서비스 범위 내의 집 개수
		int sum = 0; //집을 통해 얻을 수 있는 수익

		if (cnt * M >= cost[K]) {
			res = Math.max(res, cnt);
		}
		
		while (!q.isEmpty()) {
			K++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					//기본 범위 탐색
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(visited[ny][nx]) continue;
					if (map[ny][nx] == 1) {
						cnt++;
					}
					q.offer(new Point(ny, nx));
					visited[ny][nx] = true;
				}
			}
			if (cnt * M >= cost[K]) {
				res = Math.max(res, cnt);
			}
		}// end while
	}
}
