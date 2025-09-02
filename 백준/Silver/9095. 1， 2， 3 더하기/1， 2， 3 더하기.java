import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	//dp[i]: i를 1,2,3의 합으로 나타내는 방법의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i = 4; i < 11; i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int t = 0; t < T; t++){
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
