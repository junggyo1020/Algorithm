import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tree = new int[N];
			int maxHeight = 0; //가장 큰 나무의 높이
			for(int i = 0; i < N; i++){
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, tree[i]);
			}

			int oneCount = 0; // +1 성장이 필요한 총 횟수
			int twoCount = 0; // +2 성장이 필요한 총 횟수

			for(int i = 0; i < N; i++){
				int diff = maxHeight - tree[i];
				twoCount += diff / 2;
				oneCount += diff % 2;
			}

			// twoCount가 oneCount보다 2 이상 많으면 비효율적이므로 조정
			while (twoCount > oneCount + 1) {
				twoCount--;
				oneCount += 2;
			}

			int result = 0;
			if (oneCount > twoCount) {
				result = oneCount * 2 - 1;
			} else if (twoCount > oneCount) {
				result = twoCount * 2;
			} else {
				result = oneCount + twoCount;
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
}
