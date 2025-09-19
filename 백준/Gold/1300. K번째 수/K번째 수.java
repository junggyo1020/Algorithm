import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		long lo = -1, hi = 10_000_000_000L;
		while(lo + 1 < hi){
			long mid = lo + (hi-lo)/2;

			if(isPromising(mid)){ // F F F F T T T T
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);
	}

	private static boolean isPromising(long target){
		long cnt = 0;
		for(int i = 1; i <= N; i++){
			cnt += Math.min(N, target/i);
		}
		return cnt >= K;
	}
}
