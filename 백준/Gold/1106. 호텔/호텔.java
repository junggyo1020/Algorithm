import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int C, N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dp = new int[C+101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());

			for(int p = person; p <= C + 100; p++) {
				if(dp[p-person] != Integer.MAX_VALUE) {
					dp[p] = Math.min(dp[p], dp[p-person] + money);
				}
			}
		}

		Long answer = Long.MAX_VALUE;
		for(int p = C; p <= C + 100; p++) {
			answer = Math.min(answer, dp[p]);
		}

		System.out.println(answer);
	}

}
