import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[] isPrime;

	private static void sieve() {
		isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for(int i = 2; i*i <= 1000; i++) {
			if(isPrime[i]) {
				for(int j = i*i; j <= 1000; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//전처리
		sieve();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0; //소수의 개수
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if(isPrime[num]) {
				count++;
			}
		}

		System.out.println(count);
	}
}
