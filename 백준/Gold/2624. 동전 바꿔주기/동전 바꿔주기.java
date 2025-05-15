import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[] price = new int[k+1];
        int[] count = new int[k+1]; //동전은 k개!

        int[][] dp = new int[t+1][k+1];

        for (int i = 1; i <= k; i++) {
            price[i] = sc.nextInt();
            count[i] = sc.nextInt();
        }

        //초기화
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 1; // 금액 0을 만드는 방법은 모두 사용하지 않는 방법 1가지
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= t; i++) {
                dp[i][j] = dp[i][j-1];
                for (int l = 1; l <= count[j]; l++) {
                    int prev = i - price[j] * l;
                    if(prev < 0) break;

                    dp[i][j] += dp[prev][j-1];
                }
            }
        }

        System.out.println(dp[t][k]);
    }
}