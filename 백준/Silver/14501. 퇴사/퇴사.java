import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dp, time, cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		time = new int[N+1];
		cost = new int[N+1];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = N-1; i >= 0; i--) {
			int end = i + time[i];
			if(end <= N) {
				dp[i] = Math.max(dp[end] + cost[i], dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
		}

		System.out.println(dp[0]);
	}
}
