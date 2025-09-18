import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long lo = -1, hi = 4_294_967_296L;
		
		while(lo + 1 < hi) {
			long mid = lo + (hi - lo) / 2;
			
			if(isPromising(mid)) { //F F F F T T T T
				hi = mid;
			} else {
				lo = mid;
			}
		}
		
		System.out.println(hi);
	}
	
	private static boolean isPromising(long q) {
		if(q == 0) return N==0;
		if(q > Long.MAX_VALUE/q) return true;
		return q*q >= N;
	}
}
