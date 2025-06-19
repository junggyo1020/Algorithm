import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    private static final int SIZE = 9;
    private static int[][] board;
    private static ArrayList<int[]> blanks;

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[SIZE][SIZE];
        blanks = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) blanks.add(new int[]{i, j}); //빈칸의 위치 저장
            }
        }

        //2. 재귀 호출
        dfs(0);
    }

    private static void dfs(int depth) {
        //2-1. 종료 조건
        if (depth == blanks.size()) {
            //3. 출력 후 종료
            print();
            System.exit(0);
        }
        //2-2. 재귀
        int[] pos = blanks.get(depth);
        int row = pos[0], col = pos[1];
        for (int i = 1; i <= 9; i++) {
            //4. 검증
            if (isValid(row, col, i)) {
                board[row][col] = i;
                dfs(depth + 1);
                board[row][col] = 0;
            }
        }
    }
    private static boolean isValid(int row, int col, int num) {
        //4-1. 가로 & 세로 검증
        for (int i = 0; i < SIZE; i++) {
            if(board[row][i] == num) return false;
            if(board[i][col] == num) return false;
        }
        //4-2. 박스 검증
        int sr = (row / 3) * 3, sc = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[sr + i][sc + j] == num) return false;
            }
        }
        return true;
    }

    private static void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}