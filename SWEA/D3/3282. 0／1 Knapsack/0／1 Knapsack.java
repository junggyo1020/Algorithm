import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[] weight, value;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			weight = new int[N+1];
			value = new int[N+1];
			dp = new int[N+1][K+1];

			//가방 정보 입력
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}

			//dp[i][w] : i번째 물건까지 고려할 때 무게 w를 넘지 않는 최대 가치
			for (int i = 1; i <= N; i++) {
				for (int w = 1; w <= K; w++) {
					if(w < weight[i]) dp[i][w] = dp[i-1][w];
					else dp[i][w] = Math.max(dp[i-1][w], value[i] + dp[i-1][w-weight[i]]);
				}
			}

			sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
		} //end testcase
		System.out.println(sb);
	} //end main
}
