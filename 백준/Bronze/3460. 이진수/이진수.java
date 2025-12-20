import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int count = 0;
			while (N > 0) {
				if (N % 2 == 1) {
					sb.append(count).append(" ");
				}

				N /= 2;
				count++;
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
