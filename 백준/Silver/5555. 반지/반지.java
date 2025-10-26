import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			s += s;
			if(s.contains(str)) {
				// System.out.println(s + "는 " + str + "를 포함합니다!");
				answer++;
			}
		}

		System.out.println(answer);
	}
}
