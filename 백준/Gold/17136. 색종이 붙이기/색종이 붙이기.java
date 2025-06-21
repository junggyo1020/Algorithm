import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] board;
    static int[] count = {0, 5, 5, 5, 5, 5}; // 1x1 ~  5x5
    static int answer = Integer.MAX_VALUE; // 색종이의 최소 개수

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        //2. 순회
        dfs(0, 0);

        //3. 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int pos, int used) {
        //2-1. 종료 조건
        if (pos == 100) {
            answer = Math.min(answer, used);
            return;
        }
        //2-2. 조건 확인
        int y = pos / 10; //행
        int x = pos % 10; //열
        if (board[y][x] == 0) { // 종이 사용 못함
            dfs(pos + 1, used);
        }
        //2-3. 검증
        for (int size = 5; size > 0; size--) {
            if(count[size] == 0) continue; //이미 해당 크기 색종이 다씀
            if (canAttach(y, x, size)) {
                attach(y, x, size, 0); //색종이 붙이기
                count[size]--;
                dfs(pos + 1, used + 1);
                count[size]++;
                attach(y, x, size, 1); //색종이 떼기
            }
        }
    }

    private static boolean canAttach(int y, int x, int size) {
        if (y + size > 10 || x + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void attach(int y, int x, int size, int used) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                board[i][j] = used;
            }
        }
    }
}