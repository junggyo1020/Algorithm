import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static char[][] map;
    static int[][] fireTime;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    static class Point {
        int y, x, time;
        Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fireTime = new int[H][W];
            for (int i = 0; i < H; i++) Arrays.fill(fireTime[i], INF);

            Queue<Point> fireQ = new ArrayDeque<>();
            Point start = null;

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fireQ.offer(new Point(i, j, 0));
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        start = new Point(i, j, 0);
                    }
                }
            }

            // 1. 불의 BFS
            while (!fireQ.isEmpty()) {
                Point cur = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                    if (map[ny][nx] != '#' && fireTime[ny][nx] == INF) {
                        fireTime[ny][nx] = cur.time + 1;
                        fireQ.offer(new Point(ny, nx, cur.time + 1));
                    }
                }
            }

            // 2. 상근이의 BFS
            String result = solve(start);
            System.out.println(result);
        }
    }

    private static String solve(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[H][W];
        q.offer(start);
        visited[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                // 탈출 성공: 범위를 벗어나면 탈출
                if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                    return String.valueOf(cur.time + 1);
                }

                if (!visited[ny][nx] && map[ny][nx] == '.') {
                    // 불이 도달하는 시간보다 내가 빨리 갈 수 있는 경우만 이동
                    if (cur.time + 1 < fireTime[ny][nx]) {
                        visited[ny][nx] = true;
                        q.offer(new Point(ny, nx, cur.time + 1));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }
}