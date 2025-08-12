import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int MAX = 5_000_000;
	static int n;
	static boolean[] isPrime = new boolean[MAX+1];
	static ArrayList<Integer> primes = new ArrayList<>();
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		//#1. 초기 소수 배열 구하기
		sieve();
		
		//#2. 소수찾기
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrime[num]) {
				sb.append(num).append("\n");
				continue;
			}
			for(int x : primes) {
				if ((long)x * x > num) {
                    break;
                }
				while(num%x == 0) {
					sb.append(x).append(" ");
					num/=x;
				}
			}
			if(num > 1) sb.append(num).append(" ");
			sb.append("\n");
		}
		
		//#3. 결과 출력하기
		System.out.println(sb);
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
		
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
	}
}
