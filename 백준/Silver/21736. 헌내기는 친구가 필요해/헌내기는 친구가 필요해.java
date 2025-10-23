import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, sy, sx;
    static char[][] campus;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int answer = 0;

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                campus[i][j] = ch;
                if(ch == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        bfs(sy, sx);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static void bfs(int sy, int sx){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(sy, sx));
        visited[sy][sx] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int y = cur.y;
            int x = cur.x;

            if(campus[y][x] == 'P') {
                answer++;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(visited[ny][nx] || campus[ny][nx] == 'X') continue;
                q.offer(new Point(ny, nx));
                visited[ny][nx] = true;
            }
        }
    }
}
