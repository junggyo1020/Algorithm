import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	/**
	 * N이 10만이니까 하향식보다는 상향식 접근이 좋겠다.
	 * dp[i] = i를 제곱수의 합으로 표현할때 최소 항의 개수
	 * dp[1] = 1
	 * dp[2] = 2
	 * dp[3] = 3
	 * dp[4] = 1
	 * dp[5] = dp[4] + dp[1] = 2
	 * dp[6] = dp[4] + dp[2] = 3
	 * dp[7] = dp[4] + dp[3] = 4
	 * dp[8] = dp[4] + dp[4] = 2
	 * dp[9] = 1
	 * 
	 *
	 * @param args
	 * @throws IOException
	 */

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 1; i * i <= N; i++) {
			dp[i * i] = 1;
		}

		for(int i = 1; i <= N; i++){
			if(dp[i] == 1) continue;
			for(int j = 1; j*j < i; j++){
				dp[i] = Math.min(dp[i], dp[j*j] + dp[i-j*j]);
			}
		}

		System.out.println(dp[N]);
	}
}
