import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m, n, k, sy, sx, ey, ex, ret, area;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] grid;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        grid = new int[n][m];
        visited = new int[n][m];
        List<Integer> list = new ArrayList<>();

        for (int t = 0; t < k; t++) {
            String[] s1 = br.readLine().split(" ");
            sy = Integer.parseInt(s1[0]);
            sx = Integer.parseInt(s1[1]);
            ey = Integer.parseInt(s1[2]);
            ex = Integer.parseInt(s1[3]);
            // 종이 색칠하기
            for (int i = sy; i < ey; i++) {
                for (int j = sx; j < ex; j++) {
                    grid[i][j] = 1;
                }
            }
        }

        // Connected Component 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 0) {
                    area = 0;
                    dfs(i,j);
                    list.add(area);
                    ret++;
                }
            }
        }

        // 결과 출력
        System.out.println(ret);
        Collections.sort(list);
        for(int element : list){
            System.out.print(element + " ");
        }

    }

    public static void dfs(int y, int x){
        visited[y][x] = 1;
        area++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            //오버플로우 언더플로우 체크
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if(visited[ny][nx] == 0 && grid[ny][nx] == 0){
                dfs(ny, nx);
            }
        }
    }
}
