import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//3*N이 홀수이면 (N이 홀수이면) 타일로 채울수 없다.
		if(N % 2 == 1) {
			System.out.println(0);
			return;
		}

		//dp[i] = N이 i일 때 타일을 채우는 경우의 수
		dp = new int[N+1];
		dp[0] = 1;
		dp[2] = 3;
		for(int i = 4; i <= N; i+=2) {
			//(1)바로 전 단계에 3*2 타일을 붙이는 경우의 수
			dp[i] = dp[i-2] * 3;

			//(2)나머지 경우
			for(int j = i - 4; j >= 0; j -= 2) {
				dp[i] += dp[j] * 2;
			}
		}

		System.out.println(dp[N]);
	}
}
