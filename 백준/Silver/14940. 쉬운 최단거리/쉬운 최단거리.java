import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m, sy, sx;
    static int[][] map, visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;

                if(map[i][j] == 2) {
                    sy = i;
                    sx = j;
                }
                if(map[i][j] == 0) {
                    visited[i][j] = 0;
                }
            }
        }

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(sy, sx));
        visited[sy][sx] = 0;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int y = cur.y;
            int x = cur.x;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx] != -1) continue;

                q.offer(new Point(ny, nx));
                visited[ny][nx] = visited[y][x] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}