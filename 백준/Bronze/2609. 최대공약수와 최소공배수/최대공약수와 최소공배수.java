import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int a, b;

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}

	private static int lcm(int a, int b) {
		return (a*b) / gcd(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		if(a >= b) {
			sb.append(gcd(a, b)).append("\n").append(lcm(a, b));
		} else {
			sb.append(gcd(b, a)).append("\n").append(lcm(b, a));
		}

		System.out.println(sb);
	}
}
