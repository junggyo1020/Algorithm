import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < test_case; t++) {
            int n = Integer.parseInt(br.readLine());

            //1. 배열 선언
            long[] dp = new long[101];

            //2. 기저 사례 입력
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;

            //3. 반복문(Bottom-Up)
            for (int i = 6; i <= 100; i++) {
                dp[i] = dp[i-1] + dp[i-5];
            }

            //4. 결과 출력
            System.out.println(dp[n]);
        }
    }
}