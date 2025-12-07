import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long N;
	static boolean[] isPrime;

	private static boolean isPrime(long num) {
		if(num < 2) return false;
		if(num == 2) return true;

		for(long i = 2; i * i <= num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Long.parseLong(br.readLine());
			while(true) {
				if(isPrime(N)) {
					System.out.println(N);
					break;
				}
				N++;
			}
		}
	}
}
