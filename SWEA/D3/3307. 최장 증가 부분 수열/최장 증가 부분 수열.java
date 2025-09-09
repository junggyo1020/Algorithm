import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static long[] lis, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++){
			N = Integer.parseInt(br.readLine());
			lis = new long[N];
			arr = new long[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
			}

			long answer = 0;
			for (int i = 0; i < N; i++) {
				answer = Math.max(answer, lis[i]);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		} //end testcase
		System.out.println(sb);
	}//end main
}
