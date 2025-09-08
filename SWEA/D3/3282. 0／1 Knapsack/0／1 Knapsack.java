import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0/1 배낭 문제(Knapsack Problem)
public class Solution {

	static int N, K; // N: 물건의 개수, K: 배낭의 최대 용량
	static int[][] dp; // dp[i][w]: i번째 물건까지 고려하고, 배낭 용량이 w일 때의 최대 가치
	static int[] maxWeight, maxValue; // 각 물건의 무게(maxWeight)와 가치(maxValue)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 물건의 개수
			K = Integer.parseInt(st.nextToken()); // 배낭의 최대 용량

			// DP 테이블 및 물건 정보 배열 초기화 (0번 인덱스는 사용하지 않음)
			dp = new int[N+1][K+1];
			maxWeight = new int[N+1];
			maxValue = new int[N+1];

			// 각 물건의 무게와 가치 입력 (1-based index 사용)
			for(int i = 1; i <= N; i++){
				st = new StringTokenizer(br.readLine());
				maxWeight[i] = Integer.parseInt(st.nextToken());
				maxValue[i] = Integer.parseInt(st.nextToken());
			}

			// DP 테이블 채우기 (Bottom-up 방식)
			// i: 현재 고려하는 물건의 인덱스
			// j: 현재 배낭의 용량
			for (int i = 1; i <= N; i++) {
				for(int j = 1; j <= K; j++) {
					// 현재 물건의 무게가 배낭 용량 j보다 큰 경우
					if (maxWeight[i] > j) {
						// 현재 물건을 담을 수 없으므로, 이전 물건(i-1)까지 고려했을 때의 최대 가치를 그대로 가져옴
						dp[i][j] = dp[i - 1][j];
					} else {
						// 현재 물건을 담을 수 있는 경우
						// 1. 현재 물건을 담지 않는 경우 (dp[i-1][j])
						// 2. 현재 물건을 담는 경우 (maxValue[i] + dp[i-1][j-maxWeight[i]])
						// 위 두 가지 경우 중 더 큰 가치를 선택
						dp[i][j] = Math.max(dp[i-1][j], maxValue[i] + dp[i-1][j-maxWeight[i]]);
					}
				}
			}

			// 최종 결과: N개의 물건을 모두 고려하고, 배낭 용량이 K일 때의 최대 가치
			sb.append("#").append(t).append(" ").append(dp[N][K]).append("\n");
		}
		System.out.println(sb);
	}
}
