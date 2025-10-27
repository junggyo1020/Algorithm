import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        //적록색약이 아닌 사람
        int cntA = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    cntA++;
                }
            }
        }

        //적록색약인 사람
        //핵심아이디어 : 맵 자체를 수정하고 dfs 함수를 하나만 쓰자.
        int cntB = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    cntB++;
                }
            }
        }

        System.out.println(cntA + " " + cntB);
    }

    private static void dfs(int y, int x, char ch) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(!visited[ny][nx] && map[ny][nx] == ch) {
                dfs(ny, nx, ch);
            }
        }
    }

}

