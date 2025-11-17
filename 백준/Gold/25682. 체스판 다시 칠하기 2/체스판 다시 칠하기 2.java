import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Naive하게 계산하면, 2000*2000(N*M) => 약 400만
 * K*K번을 400만번 반복하므로 400만 * 400만 => 약 16조 => 시간초과
 * 누적합 아이디어로 K*K번 반복을 O(1)로 만들어보자!
 */
public class Main {

    static int N, M, K;
    static int answer = Integer.MAX_VALUE;
    static char[][] board;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //체스판 저장
        board = new char[N][M];
        cost = new int[N+1][M+1];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);

                char expectChar = ((i + j) % 2 == 0) ? 'B' : 'W';

                int cnt;
                if(board[i][j] == expectChar) {
                    cnt = 0;
                } else {
                    cnt = 1;
                }

                cost[i+1][j+1] = cost[i][j+1] + cost[i+1][j] - cost[i][j] + cnt;
            }
        }

        for(int i = K; i <= N; i++) {
            for(int j = K; j <= M; j++) {
                int sum = cost[i][j] - cost[i-K][j] - cost[i][j-K] + cost[i-K][j-K];

                int sum2 = K*K - sum;

                answer = Math.min(answer, Math.min(sum, sum2));
            }
        }

        System.out.println(answer);

    }
}
