import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int R, C, answer;
    static char[][] board;
    static boolean[] alpha;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    private static void dfs(int y, int x, int cnt) {
        answer = Math.max(answer, cnt);
        //2-1. 종료조건
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            int idx = board[ny][nx] - 'A';
            if (!alpha[idx]) {
                alpha[idx] = true;
                dfs(ny, nx, cnt+1);
                alpha[idx] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        alpha = new boolean[26];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        //2. 순회
        alpha[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        //3. 결과 출력
        System.out.println(answer);
    }
}