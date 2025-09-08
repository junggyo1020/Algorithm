import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0/1 배낭 문제(Knapsack Problem)
// 성능: 32384kb, 106ms
public class Solution {

	static int N, K; // N: 물건의 개수, K: 배낭의 최대 용량
	static int[] dp; // dp[i][w]: i번째 물건까지 고려하고, 배낭 용량이 w일 때의 최대 가치
	static int[] maxWeight, maxValue; // 각 물건의 무게(maxWeight)와 가치(maxValue)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			maxWeight = new int[N+1];
			maxValue = new int[N+1];
			dp = new int[K+1];

			for(int i = 1; i <= N; i++){
				st = new StringTokenizer(br.readLine());
				maxWeight[i] = Integer.parseInt(st.nextToken());
				maxValue[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = K; j >= maxWeight[i]; j--) {
					dp[j] = Math.max(dp[j], maxValue[i] + dp[j-maxWeight[i]]);
				}
			}

			// 최종 결과: N개의 물건을 모두 고려하고, 배낭 용량이 K일 때의 최대 가치
			sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
		}
		System.out.println(sb);
	}
}
