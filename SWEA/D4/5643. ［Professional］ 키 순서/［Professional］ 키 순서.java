import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 성능: 99,924 KB, 1,778 MS
 
public class Solution {

	// dp[i][j] = true: i번 학생이 j번 학생보다 키가 작음 i < j
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 학생 수
			int N = Integer.parseInt(br.readLine());
			// 키 비교 횟수
			int M = Integer.parseInt(br.readLine());
			// 1-based indexing
			dp = new boolean[N + 1][N + 1];

			// 1. 키 비교 결과 입력 받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// a < b 관계
				dp[a][b] = true;
			}

			// 2. 플로이드-워셜 알고리즘으로 모든 간접적인 키 비교 결과 갱신
			// k를 경유해서 i에서 j로 갈 수 있는지 확인
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						// i < k이고 k < j 이면 i < j
						if (dp[i][k] && dp[k][j]) {
							dp[i][j] = true;
						}
					}
				}
			}

			// 3. 각 학생에 대해 순위를 알 수 있는지 확인
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				// i번 학생과 키 비교가 가능한 학생 수
				int count = 0;
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;  // 자기 자신은 제외
					// i < j 또는 j < i인 경우 (키 비교가 가능한 경우)
					if (dp[i][j] || dp[j][i]) {
						count++;
					}
				}
				// N-1명과의 키 비교가 가능하면 순위를 알 수 있음
				if (count == N - 1) {
					answer++;
				}
			}

			// 4. 결과 저장
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}

		// 5. 모든 테스트 케이스 결과 출력
		System.out.print(sb);
	}
}