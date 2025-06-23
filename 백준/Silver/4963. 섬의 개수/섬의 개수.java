import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {

    static int w, h;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp;
        while (!Objects.equals(tmp = br.readLine(), "0 0")) {
            String[] s = tmp.split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            board = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && board[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void dfs(int y, int x) {
        for (int d = 0; d < 8; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= h || nx < 0 || nx >= w || visited[ny][nx]) continue;
            if (board[ny][nx] == 1) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}