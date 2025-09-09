import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int s = 0;
		int e = arr.length - 1;

		long minSum = Long.MAX_VALUE;
		int target1 = 0;
		int target2 = 0;
		while (s < e) {
			long sum = (long)arr[s] + arr[e];
			long absSum = Math.abs(sum);

			if (minSum > absSum) {
				minSum = absSum;
				target1 = s;
				target2 = e;
			}

			if(sum < 0) {
				s++;
			} else if(sum > 0) {
				e--;
			} else {
				break;
			}
		}

		System.out.println(arr[target1] + " " + arr[target2]);
	}
}
