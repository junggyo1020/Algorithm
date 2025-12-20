import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, M;
	static boolean[] isPrime;
	static final int SIZE = 10000;

	private static void sieve() {
		isPrime = new boolean[SIZE+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for(int i = 2; i*i <= N; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j <= N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		int sum = 0;
		int min = Integer.MAX_VALUE;

		sieve();
		boolean flag = false;

		for(int i = M; i <= N; i++) {
			if(isPrime[i]) {
				sum += i;
				min = Math.min(min, i);
				flag = true;
			}
		}

		if(flag) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}
}
