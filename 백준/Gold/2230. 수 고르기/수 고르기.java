import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int lt = 0;
		int rt = 0;
		int minDiff = Integer.MAX_VALUE;
		while(rt < N) {
			int diff = arr[rt] - arr[lt];

			if(diff >= M) {
				if(diff < minDiff) {
					minDiff = diff;
				}
				lt++;
				if(lt >= N) break;
			} else {
				rt++;
			}
		}

		System.out.println(minDiff);
	}
}
