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
        dfs(0, 0); //현재 위치, 사용된 색종이 개수

        //3. 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int pos, int used) {
        //2-1. 종료 조건
        if (pos == 100) {
            answer = Math.min(answer, used);
            return;
        }

        int y = pos / 10;
        int x = pos % 10;

        //0인 칸은 색종이를 붙일 수 없다.
        if (board[y][x] == 0) {
            dfs(pos + 1, used);
            return;
        }

        //2-2. 백트래킹 & 순회
        for (int size = 5; size > 0; size--) {
            if(count[size] == 0) continue;
            if (canAttach(y, x, size)) { //색종이 붙일 수 있는 경우
                attach(y, x, size, 0); //색종이 붙이기
                count[size]--;
                dfs(pos + 1, used + 1);
                count[size]++;
                attach(y, x, size, 1); //색종이 다시 떼기
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