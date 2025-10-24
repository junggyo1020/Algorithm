import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int X, Y;
	static long Z;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = (long)Y * 100 / X;

		if (Z >= 99) {
			System.out.println(-1);
			return;
		}

		long lo = 0, hi = (long)1e11;
		while(lo + 1 < hi) {
			long mid = lo + (hi-lo)/2;
			if((Y + mid) * 100 / (X + mid) > Z) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		System.out.println(hi);
	}
}
