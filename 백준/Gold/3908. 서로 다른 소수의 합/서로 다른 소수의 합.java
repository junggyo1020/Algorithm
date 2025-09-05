import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/**
	 * n을 서로 다른 k개의 소수의 합으로 나타내는 방법의 수
	 *
	 * 1. 상향식 dp로 접근하자
	 * 2. dp[k][i] : i를 서로 다른 k개의 소수의 합으로 나타내는 방법의 수
	 * 3. 1부터 n(최대 1120)까지 에라토스테네스의 체로 소수 배열을 구한다.
	 * 4. dp[k][i] += dp[k-1][n-p]
	 *
	 */

	static int N, K;
	static boolean[] isPrime;
	static final int MAX_N = 1120;
	static final int MAX_K = 14;
	static ArrayList<Integer> primes = new ArrayList<>();
	static int[][] dp = new int[MAX_K+1][MAX_N+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sieve();
		dp();

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			sb.append(dp[K][N]).append("\n");
		}
		System.out.println(sb);
	}

	private static void sieve(){
		isPrime = new boolean[MAX_N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i <= MAX_N; i++){
			if(isPrime[i]){
				for(long j = (long)i*i; j <= MAX_N; j+=i){
					isPrime[(int)j] = false;
				}
			}
		}

		for(int i = 2; i <= MAX_N; i++){
			if(isPrime[i]){
				primes.add(i);
			}
		}
	}

	private static void dp(){
		dp[0][0] = 1;
		
		for(int p : primes){
			for(int n = MAX_N; n >= p; n--){
				for(int k = 1; k <= MAX_K; k++){
					dp[k][n] += dp[k-1][n-p];
				}
			}
		}
	}
}
