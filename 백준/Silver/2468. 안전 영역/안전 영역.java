
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] grid;
    static int[][] visited;
    static int n;
    static int max_ret = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        int max_height = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
                max_height = Math.max(max_height, grid[i][j]);
            }
        }

        for (int t = 0; t <= max_height; t++) {
            int ret = 0;
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]==0 && grid[i][j] > t){
                        dfs(i,j,t);
                        ret++;
                    }
                }
            }
            max_ret = Math.max(max_ret, ret);
        }
        System.out.println(max_ret);
    }

    public static void dfs(int y, int x, int t){
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if(visited[ny][nx] == 0 && grid[ny][nx] > t){
                dfs(ny, nx, t);
            };
        }
    }
}
