import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/**
	 * 시간초과 뜰 때 해결법
	 * Top-down 대신, Bottom-up을 사용하자!
	 */

	// Top-down 방식
	//dp[i] : i에서 1을 만드는데 걸리는 연산의 최솟값
	// static int[] dp;
	// private static int solve(int n) {
	// 	if(n == 1) return 0;
	//
	// 	if(dp[n] != 0) return dp[n];
	//
	// 	int result = solve(n-1) + 1;
	// 	if(n%3==0){
	// 		result = Math.min(result, solve(n/3) + 1);
	// 	}
	// 	if(n%2==0){
	// 		result = Math.min(result, solve(n/2) + 1);
	// 	}
	//
	// 	return dp[n] = result;
	// }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		dp[1] = 0;

		for(int i = 2; i <= N; i++){
			dp[i] = dp[i-1] + 1;
			if(i%3==0){
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			if(i%2==0){
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
