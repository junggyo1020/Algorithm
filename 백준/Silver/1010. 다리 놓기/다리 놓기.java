import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] dp;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dp = new int[31][31];
			for (int i = 0; i < 30; i++) {
				dp[i][i] = 1; // nCn = 1
				dp[i][0] = 1; // nC0 = 1
			}

			for (int i = 2; i < 30; i++) {
				for (int j = 1; j < i; j++) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
			System.out.println(dp[M][N]);
		}
	}
}
