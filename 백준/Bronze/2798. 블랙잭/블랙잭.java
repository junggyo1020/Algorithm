import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] numbers;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++ ) {
				for(int k = j + 1; k < N; k++ ){
					int sum = numbers[i] + numbers[j] + numbers[k];
					if(sum > M) continue;
					if(sum <= M) {
						if(sum == M) {
							System.out.println(sum);
							return;
						}
						answer = Math.max(answer, sum);
					}
				}
			}
		}

		System.out.println(answer);
	}
}
