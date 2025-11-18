import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static Integer[] numbers;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new Integer[N];
        prefixSum = new int[N+1];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for(int i = 0; i < N; i++) {
            prefixSum[i+1] = prefixSum[i] + numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[e] - prefixSum[s-1]).append("\n");
        }

        System.out.println(sb);
    }
}
