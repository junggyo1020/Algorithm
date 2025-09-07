import java.util.Scanner;

public class Main {
	/**
	 * 0으로 시작하지 않는다.
	 * 1이 두번 연속으로 나타나지 않는다.
	 * dp[N] : N자리 이진수의 개수
	 * dp[1] = 1
	 * dp[2] = 10 = 1
	 * dp[3] = 100 101 = 2
	 * dp[4] = 1001 1010 1000 = 3
	 * dp[5] = 10000 10001 10010 10100 10101 = 5
	 * dp[6] = 100000 100001 100010 100100 100101 101000 101001 101010 = 8
	 * dp[N] = dp[N-1] + dp[N-2]
	 * @param args
	 */

	static long[] dp;

	private static long dp(int n){
		if(dp[n] > 0) return dp[n];
		if(n == 1 || n == 2) return dp[n] = 1;

		return dp[n] = dp(n-1) + dp(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		dp = new long[n+1];
		System.out.println(dp(n));
	}
}
