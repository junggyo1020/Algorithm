import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MAX = 1_000_000;
	static final long MOD = 1_000_000_009L;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp = new long[MAX + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i = 4; i <= MAX; i++) {
			dp[i] = ((long)dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
		}
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}
