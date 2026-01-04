import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			//공백채우기
			for(int j = 0; j < N-i-1; j++) {
				sb.append(" ");
			}

			//별 채우기
			for(int j = 0; j <= i; j++) {
				sb.append("* ");
			}

			//공백
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
