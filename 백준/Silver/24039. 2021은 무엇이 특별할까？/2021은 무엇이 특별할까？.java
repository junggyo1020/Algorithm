import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	static int N;
	static boolean[] isPrime;
	static ArrayList<Integer> prime;
	
	static final int MAX = 200;

	private static void sieve() {
		isPrime = new boolean[MAX+1];
		prime = new ArrayList<>();
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for(int i = 2; i*i <= MAX; i++) {
			if(isPrime[i]) {
				for(long j = (long)i*i; j <= MAX; j+=i) {
					isPrime[(int)j] = false;
				}
			}
		}

		for(int i = 2; i <= MAX; i++) { // i <= 200
			if(isPrime[i]) {
				prime.add(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sieve(); 
		
		//연속된 두 소수의 곱이였다...
		for (int i = 0; i < prime.size() - 1; i++) {
			int p1 = prime.get(i);     // i번째 소수
			int p2 = prime.get(i+1);   // i+1번째 소수

			long specialNum = (long)p1 * p2;

			if (specialNum > N) {
				System.out.println(specialNum);
				break;
			}
		}
	}
}