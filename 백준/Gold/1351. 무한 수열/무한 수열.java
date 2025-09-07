import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static long N;
	static int P, Q;
	static HashMap<Long, Long> hm = new HashMap<>();

	private static long dp(long n){
		if(hm.containsKey(n)) return hm.get(n);
		if(n == 0L) {
			return 1L;
		}

		long result = dp(n/P) + dp(n/Q);
		hm.put(n, result);
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		System.out.println(dp(N));
	}
}
