import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static String[] str, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			res = new String[N];
			str = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				str[i] = st.nextToken();
			}

			//퍼펙트 셔플
			int mid = (N + 1) / 2;
			res = new String[N];

			int firstIdx = 0;  // 첫 번째 덱 포인터
			int secondIdx = mid; // 두 번째 덱 포인터

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) { // 결과 배열의 짝수 번째 자리에는
					res[i] = str[firstIdx++];
				} else { // 결과 배열의 홀수 번째 자리에는
					res[i] = str[secondIdx++];
				}
			}

			sb.append("#").append(t);
			for (String x : res) {
				sb.append(" ").append(x);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	} //end main
}
