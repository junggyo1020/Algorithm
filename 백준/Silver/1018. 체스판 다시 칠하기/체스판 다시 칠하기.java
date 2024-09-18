import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        // 8x8 크기의 체스판을 확인
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, getMinRepaintCount(board, i, j));
            }
        }

        System.out.println(minCount);
    }

    // 주어진 시작 좌표에서 8x8 체스판을 확인하여 최소 칠해야 할 횟수를 계산
    private static int getMinRepaintCount(char[][] board, int x, int y) {
        int repaintW = 0; // W로 시작하는 체스판으로 다시 칠하는 경우
        int repaintB = 0; // B로 시작하는 체스판으로 다시 칠하는 경우

        char[][] patternW = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        char[][] patternB = {
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };

        // 8x8 체스판을 검사
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != patternW[i][j]) {
                    repaintW++;
                }
                if (board[x + i][y + j] != patternB[i][j]) {
                    repaintB++;
                }
            }
        }

        // 두 가지 경우 중 최소 칠해야 하는 횟수를 반환
        return Math.min(repaintW, repaintB);
    }
}
