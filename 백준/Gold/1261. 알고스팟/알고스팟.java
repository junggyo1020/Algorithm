import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int[][] map, dist;
    static final int INF = 987654321;
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            Arrays.fill(dist[i], INF);
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //0-1 BFS
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(0, 0));
        dist[0][0] = 0;

        while(!dq.isEmpty()) {
            Point cur = dq.poll();
            if(cur.y == N-1 && cur.x == M-1) break;

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M) continue;

                if(map[ny][nx] == 1) {
                    if(dist[ny][nx] > dist[cur.y][cur.x] + 1) {
                        dist[ny][nx] = dist[cur.y][cur.x] + 1;
                        dq.offerLast(new Point(ny, nx));
                    }
                } else {
                    if(dist[ny][nx] > dist[cur.y][cur.x]) {
                        dist[ny][nx] = dist[cur.y][cur.x];
                        dq.offerFirst(new Point(ny, nx));
                    }
                }
            }
        }

        System.out.println(dist[N - 1][M - 1] == INF ? 0 : dist[N-1][M-1]);
    }
}