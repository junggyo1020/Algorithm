import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		//구간합 -> 누적합
		//1부터 100까지 더하면 5050이므로 충분하다.
		int size = 1000;
		int[] arr = new int[size+2];
		int cnt = 1;

		out:
		for(int i = 1; i <= 100; i++) {
			for(int j = 0; j < i; j++) {
				arr[cnt++] = i;
				if(cnt > size) break out;
			}
		}

		// 1 2 2 3 3 3 4 4 4 4
		// 1 3 5 8 11 14 18 22
		long[] pSum = new long[size+2];
		for(int i = 1; i <= 1000; i++) {
			pSum[i] = arr[i] + pSum[i-1];
		}

		System.out.println(pSum[B] - pSum[A-1]);
	}
}