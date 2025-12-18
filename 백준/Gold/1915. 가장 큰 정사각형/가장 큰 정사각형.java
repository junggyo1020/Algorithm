import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= M; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}

		//TODO : arr[i][j] = i,j까지의 가장 큰 정사각형의 넓이
		long maxLen = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				int num = arr[i][j];
				if(num == 1) {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}

		System.out.println(maxLen * maxLen);
	}
}
