import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static long A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		//정렬하기
		Arrays.sort(numbers);
		long minDiff = Integer.MAX_VALUE;

		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				A = numbers[i] + numbers[j];

				//투포인터 사용하기
				int lt = 0;
				int rt = N-1;
				while(lt < rt) {
					if(lt == i || lt == j) {
						lt++;
						continue;
					}
					if(rt == i || rt == j) {
						rt--;
						continue;
					}

					B = numbers[lt] + numbers[rt];
					long diff = A - B;
					if(diff == 0) {
						System.out.println(0);
						return;
					}

					if(minDiff > Math.abs(diff)) {
						minDiff = Math.abs(diff);
					}

					if(diff > 0) {
						lt++;
					} else {
						rt--;
					}
				}
			}
		}

		System.out.println(minDiff);
	}
}
