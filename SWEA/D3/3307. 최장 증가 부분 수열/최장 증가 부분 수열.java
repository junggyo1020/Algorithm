import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최적화 합시다. (DP + 이분탐색 ver.) -> O(NlogN)
 *
 * 차이 비교
 * O(N^2) 방식 : 32,244 KB / 117 MS
 * O(NlogN) 방식 : 28,032 KB / 95 MS
 * 
 * N이 커질 수록 성능 차이는 매우 커질 것.
 */
public class Solution {

	static int N;
	static long[] arr;
	static long[] dp; // dp[i]: 길이가 i+1인 LIS의 마지막 원소 중 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++){
			N = Integer.parseInt(br.readLine());
			arr = new long[N];
			dp = new long[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}

			int length = 0; //현재 LIS의 길이
			for (int i = 0; i < N; i++) {
				int pos = binarySearch(arr[i], 0, length - 1, length);
				dp[pos] = arr[i];

				//모든 현재 원소가 기존 LIS의 모든 원소보다 큰 경우 맨뒤에 추가한다.
				if(pos == length) {
					length++;
				}
			}

			sb.append("#").append(t).append(" ").append(length).append("\n");
		} //end testcase
		System.out.println(sb);
	}//end main

	/**
	 * target이 들어갈 위치를 이진 탐색으로 찾기!
	 * @param target: 알맞은 위치에 넣을 값
	 * @param lt: 시작 인덱스
	 * @param rt: 끝 인덱스
	 * @param size: 현재까지 LIS 길이
	 * @return : target이 들어가야 하는 위치
	 */
	private static int binarySearch(long target, int lt, int rt, int size){
		int res = size; //초기값: 모든 원소보다 큰 경우 맨 뒤에 추가

		while(lt <= rt){
			int mid = lt + (rt - lt) / 2;
			if(dp[mid] >= target) {
				res = mid;
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}

		return res;
	}
}
