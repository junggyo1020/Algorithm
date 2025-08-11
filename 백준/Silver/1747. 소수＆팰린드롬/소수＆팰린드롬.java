import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static final int MAX = 2_000_000;
	static boolean[] isPrime = new boolean[MAX + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		sieve();
		
		for(int i = n; i<=MAX; i++) {
			if(isPrime[i] && isPalindrome(i)) {
				System.out.println(i);
				return;
			}
		}
	}
	
	private static void sieve() {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; (long)i*i <= MAX; i++) {
			if(isPrime[i]) {
				for(long j = (long)i*i; j <= MAX; j+=i) {
					isPrime[(int)j] = false;
				}
			}
		}
	}
	private static boolean isPalindrome(int num) {
		String str = String.valueOf(num);
		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();
		return str.equals(reverse);
	}

}
