import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] numbers;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		//연속된 수들의 부분합 구하기
		int lt = 0;
		int sum = 0;
		boolean flag = false;
		for(int rt = 0; rt < N; rt++) {
			sum += numbers[rt];
			while(sum >= S) {
				answer = Math.min(answer, rt - lt + 1);
				sum -= numbers[lt];
				lt++;
				flag = true;
			}
		}


		System.out.println(flag ? answer : 0);
	}
}
