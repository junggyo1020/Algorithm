import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	/**
	 * dp[i] : i를 1로 만드는 횟수의 최솟값 구하기
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] prev = new int[N+1];

		dp[1] = 0;
		prev[1] = -1;

		for(int i = 2; i <= N; i++){
			dp[i] = dp[i-1] + 1;
			prev[i] = i-1;

			if(i%3==0 && dp[i] > (dp[i/3]+1)){
				dp[i] = Math.min(dp[i], dp[i/3]+1);
				prev[i] = i/3;
			}

			if(i%2==0 && dp[i] > (dp[i/2]+1)){
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
				prev[i] = i/2;
			}
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = N; i != -1; i = prev[i]){
			q.offer(i);
		}

		sb.append(dp[N]).append("\n");
		
		while (!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		
		System.out.println(sb);
	}
}
