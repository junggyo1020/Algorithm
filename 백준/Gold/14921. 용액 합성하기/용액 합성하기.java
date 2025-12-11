import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		/**
		 * 두 포인터의 값들을 더해서 조건을 만족해야 함.
		 * 양쪽 끝 포인터에서 시작하기!
		 */
		int lt = 0;
		int rt = N-1;
		int fitSum = Integer.MAX_VALUE;
		while(lt < rt) {
			int sum = arr[lt] + arr[rt];
			if(sum == 0) {
				System.out.println(0);
				return;
			}

			if (Math.abs(sum) < Math.abs(fitSum)) {
				fitSum = sum;
			}

			if(sum > 0) {
				rt--;
			} else {
				lt++;
			}
		}
		System.out.println(fitSum);
	}
}
