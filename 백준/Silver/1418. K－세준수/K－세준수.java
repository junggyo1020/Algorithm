import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static boolean[] isPrime;
	static final int MAX = 100_000;

	private static void sieve() {
		isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for(int i = 2; i*i <= MAX; i++) {
			if(isPrime[i]) {
				for(long j = i*i; j <= MAX; j+=i) {
					isPrime[(int)j] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		sieve();

		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			int num = i;
			// System.out.println("num = " + num);
			for(int j = 2; j <= K; j++) {
				if(isPrime[j] && (num%j == 0)) {
					// System.out.println("j = " + j);
					while(num%j == 0) {
						num /= j;
					}
					// System.out.println(j + "로 나눈 후 num = " + num);
				}
			}
			if(num == 1) {
				// System.out.println("만족하는 수 추가 : " + i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
