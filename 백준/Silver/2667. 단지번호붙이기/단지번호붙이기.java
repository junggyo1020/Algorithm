import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, ret, cnt;
    static int[][] grid;
    static int[][] visited;

    public static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(new int[]{y, x});
        ret = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 오버 플로우, 언더플로우 체크
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                // 방문하지 않았고, 집이 존재하는 경우 이어서 탐색
                if(visited[ny][nx] == 0 && grid[ny][nx] != 0){
                    visited[ny][nx] = 1;
                    q.add(new int[]{ny, nx});
                    ret += 1;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 배열 재정의
        grid = new int[n][n];
        visited = new int[n][n];

        // 지도 입력하기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않았고, 집이 존재하는 경우
                if (visited[i][j] == 0 && grid[i][j] != 0) {
                    list.add(bfs(i,j));
                    cnt++;
                }
            }
        }

        // 리스트를 오름차순 정렬
        Collections.sort(list);

        // 결과 출력
        System.out.println(cnt);
        for (int i : list) {
            System.out.println(i);
        }
    }
}