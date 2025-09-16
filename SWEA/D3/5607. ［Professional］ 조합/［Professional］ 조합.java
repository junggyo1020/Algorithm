import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 나누는 값 (소수)
    static final long P = 1234567891;
    static long[] fact; // 팩토리얼 값을 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 팩토리얼 전처리 (최대 N=1,000,000 까지)
        fact = new long[1000001];
        fact[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            fact[i] = (fact[i - 1] * i) % P;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 2. A = N!
            long A = fact[N];

            // 3. B = (R! * (N-R)!) % P
            long B = (fact[R] * fact[N - R]) % P;

            // 4. B_inv = B^(P-2) % P (페르마의 소정리)
            long B_inverse = pow(B, P - 2);

            // 5. result = (A * B_inverse) % P
            long result = (A * B_inverse) % P;

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 모듈러 거듭제곱 (분할 정복)
     * (base^exp) % P 를 계산
     */
    static long pow(long base, long exp) {
        long res = 1;
        base %= P;

        while (exp > 0) {
            // 지수가 홀수이면, 결과에 base를 한 번 곱함
            if (exp % 2 == 1) {
                res = (res * base) % P;
            }
            
            // base를 제곱하고 지수를 절반으로 줄임
            base = (base * base) % P;
            exp /= 2;
        }
        return res;
    }
}