import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++){
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			dp = new boolean[N+1][N+1];
			for(int i = 0; i < M; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dp[a][b] = true;
			}

			for(int k = 1; k <= N; k++){
				for(int i = 1; i <= N; i++){
					for(int j = 1; j <= N; j++){
						if(dp[i][k] && dp[k][j]){
							dp[i][j] = true;
						}
					}
				}
			}

			int answer = 0;
			for(int i = 1; i <= N; i++){
				int count = 0;
				for(int j = 1; j <= N; j++){
					if(i==j) continue;
					if(dp[i][j] || dp[j][i]) count++;
				}
				if(count == N-1) answer++;
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
