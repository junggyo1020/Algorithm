import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, X;
	static int[] numbers;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());

		Arrays.sort(numbers);

		int lt = 0, rt = N-1;

		while(lt < rt) {
			int sum = numbers[lt] + numbers[rt];
			if(sum == X) {
				answer++;
				lt++;
				rt--;
			} else if(sum < X) {
				lt++;
			} else {
				rt--;
			}
		}

		System.out.println(answer);
	}
}
