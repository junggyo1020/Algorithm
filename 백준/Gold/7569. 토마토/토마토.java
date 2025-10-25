import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H, sh, sy, sx, tomatoCnt;
	static int[][][] box;
	static boolean[][][] visited;
	static final int[] dh = {1, -1, 0, 0, 0, 0}; //위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static final int[] dy = {0, 0, 0, 0, -1, 1};
	static final int[] dx = {0, 0, -1, 1, 0, 0};
	static int answer = -1;
	static Queue<Point> q;

	static class Point {
		int h, y, x;
		Point(int h, int y, int x) {
			this.h = h;
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M]; //높이, 세로, 가로
		visited = new boolean[H][N][M];
		q = new ArrayDeque<>();

		tomatoCnt = 0; //익지 않은 토마토 개수
		for(int h = 0; h < H; h++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					box[h][i][j] = Integer.parseInt(st.nextToken());
					if(box[h][i][j] == 0) tomatoCnt++;
					if(box[h][i][j] == 1) {
						q.offer(new Point(h, i, j));
						visited[h][i][j] = true;
					}
				}
			}
		}

		//엣지케이스
		if(tomatoCnt == 0) {
			System.out.println(0);
			System.exit(0);
		}

		int time = 1;
		loop:
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Point cur = q.poll();
				int ch = cur.h;
				int cy = cur.y;
				int cx = cur.x;

				for(int i = 0; i < 6; i++) {
					int nh = ch + dh[i];
					int ny = cy + dy[i];
					int nx = cx + dx[i];

					if(nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					if(box[nh][ny][nx] == -1 || visited[nh][ny][nx]) continue;

					q.offer(new Point(nh, ny, nx));
					box[nh][ny][nx] = 1;
					visited[nh][ny][nx] = true;
					tomatoCnt--;
					if(tomatoCnt == 0) {
						answer = time;
						break loop;
					}
				}
			}
			time++;
		}

		System.out.println(answer);
	}
}
