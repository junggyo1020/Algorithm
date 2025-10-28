import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] Y, X;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Y = new int[N];
        X = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Y[i] = Integer.parseInt(st.nextToken());
            X[i] = Integer.parseInt(st.nextToken());
        }

        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < N; i++) {
            int next = (i + 1) % N;

            sum1 += (long)Y[next] * X[i];
            sum2 += (long)Y[i] * X[next];
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}
