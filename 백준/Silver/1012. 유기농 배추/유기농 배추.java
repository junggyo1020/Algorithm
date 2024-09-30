import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static int[][] grid;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 테스트 케이스 반복
        for (int T = 0; T < t; T++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            grid = new int[n][m];
            visited = new int[n][m];

            // 배추 심기
            for (int i = 0; i < k; i++) {
                String[] cab = br.readLine().split(" ");
                int x = Integer.parseInt(cab[0]);
                int y = Integer.parseInt(cab[1]);
                grid[y][x] = 1;
            }

            int count = 0;
            // 흰 지렁이 개수 찾기(dfs)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(visited[i][j] == 0 && grid[i][j] == 1){
                        dfs(i,j,n,m);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int y, int x,int n,int m) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (visited[ny][nx] == 0 && grid[ny][nx] == 1) {
                dfs(ny, nx, n, m);
            }
        }
    }

}
