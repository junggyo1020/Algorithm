import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        //dp[i] = i번째 계단을 밟았을 때의 최대 점수
        int[] dp = new int[n+1];

        //1. 초기값 설정
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        //2. 점화식
        for (int i = 3; i <= n; i++) {
            //2-1. i-2 에서 온경우
            int case1 = dp[i-2] + stairs[i];
            //2-2. i-1 에서 온경우
            int case2 = dp[i-3] + stairs[i-1] + stairs[i];
            //2-3. 이 중 최대값 구하기
            dp[i] = Math.max(case1, case2);
        }

        System.out.println(dp[n]);
    }
}