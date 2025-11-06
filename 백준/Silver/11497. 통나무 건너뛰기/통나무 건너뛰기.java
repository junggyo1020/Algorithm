import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            long sum = Math.abs(numbers[0] - numbers[1]);
            for(int i = 0; i < N - 2; i++) {
                sum = Math.max(Math.abs(numbers[i] - numbers[i+2]), sum);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
