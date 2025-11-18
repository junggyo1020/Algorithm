import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int[] prefixSum = new int[N+1];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            prefixSum[i+1] = prefixSum[i] + numbers[i];
        }

        for(int i = K; i <= N; i++) {
            answer = Math.max(answer, prefixSum[i] - prefixSum[i-K]);
        }

        System.out.println(answer);
    }

}
