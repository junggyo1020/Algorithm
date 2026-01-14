import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int K;
    static int W, H;
    static int[][] map;
    static final int[] dy1 = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] dx1 = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy2 = {-1, 1, 0, 0};
    static final int[] dx2 = {0, 0, -1, 1};
    static boolean[][][] visited;

    static class Point {
        int y, x, move, dist;
        Point(int y, int x, int move, int dist) {
            this.y = y;
            this.x = x;
            this.move = move; //말의 움직임
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.y == H - 1 && cur.x == W - 1) {
                System.out.println(cur.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy2[i];
                int nx = cur.x + dx2[i];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (visited[ny][nx][cur.move] || map[ny][nx] == 1) continue;

                if (map[ny][nx] != 1) {
                    q.offer(new Point(ny, nx, cur.move, cur.dist + 1));
                    visited[ny][nx][cur.move] = true;
                }
            }

            if (cur.move < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = cur.y + dy1[i];
                    int nx = cur.x + dx1[i];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if (visited[ny][nx][cur.move+1] || map[ny][nx] == 1) continue;

                    if (map[ny][nx] != 1) {
                        q.offer(new Point(ny, nx, cur.move+1, cur.dist + 1));
                        visited[ny][nx][cur.move + 1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}