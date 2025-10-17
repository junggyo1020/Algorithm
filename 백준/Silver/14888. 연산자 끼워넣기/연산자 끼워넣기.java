import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static int[] operators = new int[4]; // +, -, *, / 의 개수
	static int max = Integer.MIN_VALUE; // 최댓값
	static int min = Integer.MAX_VALUE; // 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수의 개수

		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N]; // 숫자 배열
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		// 백트래킹(DFS)
		dfs(numbers[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int num, int idx) {
		// Step 3. 모든 숫자를 다 사용했으면 최댓값/최솟값 갱신
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 사용할 수 있는 연산자가 남아있는 경우
			if (operators[i] > 0) {
				// 해당 연산자 개수를 하나 줄임 (사용 처리)
				operators[i]--;

				switch (i) {
					case 0: // 덧셈
						dfs(num + numbers[idx], idx + 1);
						break;
					case 1: // 뺄셈
						dfs(num - numbers[idx], idx + 1);
						break;
					case 2: // 곱셈
						dfs(num * numbers[idx], idx + 1);
						break;
					case 3: // 나눗셈
						dfs(num < 0 ? -1 * (Math.abs(num) / numbers[idx]) : num / numbers[idx], idx + 1);
						break;
				}
				operators[i]++;
			}
		}
	}
}