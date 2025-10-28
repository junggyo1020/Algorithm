import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] numbers;
    static int answer;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N*M 순회
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, numbers[i][j]);
                visited[i][j] = false;

                checkT(i, j);
            }
        }
        
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int depth, int sum) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if(visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1, sum + numbers[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    private static void checkT(int y, int x) {
        //ㅗ
        if(y-1 >= 0 && x-1 >= 0 && x + 1 < M) {
            int sum = numbers[y][x] + numbers[y-1][x] + numbers[y][x-1] + numbers[y][x+1];
            answer = Math.max(answer, sum);
        }
        //ㅏ
        if(y-1 >= 0 && y+1 < N && x+1 < M) {
            int sum = numbers[y][x] + numbers[y-1][x] + numbers[y][x+1] + numbers[y+1][x];
            answer = Math.max(answer, sum);
        }
        //ㅓ
        if(y-1 >= 0 && y+1 < N && x-1 >= 0) {
            int sum = numbers[y][x] + numbers[y-1][x] + numbers[y+1][x] + numbers[y][x-1];
            answer = Math.max(answer, sum);
        }
        //ㅜ
        if(y+1 < N && x-1 >= 0 && x+1 < M) {
            int sum = numbers[y][x] + numbers[y+1][x] + numbers[y][x-1] + numbers[y][x+1];
            answer = Math.max(answer, sum);
        }
    }
}
