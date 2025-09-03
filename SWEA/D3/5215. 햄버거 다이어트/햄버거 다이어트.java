import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			int[] scores = new int[N + 1];
			int[] cals = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}

			// dp[i][j] : i번째 재료까지 고려했고, 칼로리 한도가 j일 때의 최대 점수
			int[][] dp = new int[N + 1][L + 1];

			// i는 재료, j는 칼로리 한도
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					// 현재 재료(i)의 칼로리가 한도(j)보다 커서 선택할 수 없는 경우
					if (cals[i] > j) {
						dp[i][j] = dp[i - 1][j]; // 이전 재료까지만 고려한 값을 그대로 가져옴
					} else {
						// 선택하지 않는 경우 vs 선택하는 경우 중 더 큰 값을 저장
						// 1. 선택하지 않는 경우: dp[i - 1][j]
						// 2. 선택하는 경우: scores[i] + dp[i-1][j - cals[i]]
						dp[i][j] = Math.max(dp[i - 1][j], scores[i] + dp[i - 1][j - cals[i]]);
					}
				}
			}

			// N개의 재료를 모두 고려했고, 최대 칼로리 한도가 L일 때의 최대 점수
			System.out.printf("#%d %d\n", t, dp[N][L]);
		}
	}
}