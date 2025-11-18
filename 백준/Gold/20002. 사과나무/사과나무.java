import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] trees, prefixSum;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        trees = new int[N][N];
        prefixSum = new int[N+1][N+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                trees[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + trees[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int K = 1; K <= N; K++) {
            for (int i = K; i <= N; i++) {
                for (int j = K; j <= N; j++) {
                    int sum = prefixSum[i][j] - prefixSum[i-K][j] - prefixSum[i][j-K] + prefixSum[i-K][j-K];
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}
