import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] arr;
	static int[] dp;
	static int maxLen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				dp[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			
			int maxLen = 0;
			for(int i = 0; i < N; i++) {
				maxLen = Math.max(maxLen, dp[i]);
			}
			System.out.println("#" + t + " " + maxLen);
		}
	}// end Main
}
