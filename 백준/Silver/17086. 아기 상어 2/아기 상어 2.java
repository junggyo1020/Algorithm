import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][] visited;
    static int answer;
    static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

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
        arr = new int[N][M];
        visited = new int[N][M];
        Queue<Point> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
                if (arr[i][j] == 1) {
                    visited[i][j] = 0;
                    q.offer(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M || visited[ny][nx]!=-1) continue;
                
                visited[ny][nx] = visited[cur.y][cur.x] + 1;
                answer = Math.max(answer, visited[ny][nx]);
                q.offer(new Point(ny, nx));
            }
        }
        System.out.println(answer);
    }
}
