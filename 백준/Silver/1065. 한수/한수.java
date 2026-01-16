import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(countHanSu(N));
	}

	private static int countHanSu(int n) {
		if (n < 100) {
			// 1~99는 모두 한수이므로 그대로 반환
			return n;
		}

		// 100 이상일 경우 99개(1~99)는 기본으로 확보
		int count = 99;

		// 100부터 N까지 검사
		for (int i = 100; i <= n; i++) {
			// 1000은 문제 조건상 한수가 아니므로 제외 (1000 이하 자연수 조건)
			if (i == 1000) break;

			int hundreds = i / 100;      // 백의 자리
			int tens = (i / 10) % 10;    // 십의 자리
			int units = i % 10;          // 일의 자리

			// 각 자릿수가 등차수열을 이루는지 확인
			if ((hundreds - tens) == (tens - units)) {
				count++;
			}
		}
		return count;
	}
}