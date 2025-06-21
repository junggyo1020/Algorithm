import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    static int[] count = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 순회
        dfs(0, 0); //현재 위치, 색종이 최소 개수

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int pos, int cnt) {
        if (pos == 100) {
            answer = Math.min(answer, cnt);
            return;
        }

        int y = pos / 10;
        int x = pos % 10;
        if (board[y][x] == 0) {
            dfs(pos + 1, cnt);
            return;
        }

        for (int size = 5; size > 0; size--) {
            if(count[size] == 0) continue;
            if (canAttach(y, x, size)) {
                attach(y, x, size, 0);
                count[size]--;
                dfs(pos + 1, cnt + 1);
                count[size]++;
                attach(y, x, size, 1);
            }
        }
    }

    private static boolean canAttach(int y, int x, int size) {
        if(y + size > 10 || x + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(board[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void attach(int y, int x, int size, int val) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                board[i][j] = val;
            }
        }
    }
}