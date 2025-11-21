import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Long B;
    static long[][] A;

    static final int C = 1000;

    static long[][] Pow(long[][] A, long b) {
        if(b == 1) return A; // 1

        long[][] half = Pow(A, b/2); // 2

        long[][] result = multiply(half, half);
        if(b % 2 == 1) return multiply(result, A);
        return result;
    }

    static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] result = new long[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    result[i][j] += o1[i][k] * o2[k][j];
                    result[i][j] %= C;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new long[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken()) % C;
            }
        }

        A = Pow(A, B);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
