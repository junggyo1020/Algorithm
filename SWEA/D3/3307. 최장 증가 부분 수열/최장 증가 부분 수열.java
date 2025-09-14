import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int length = 0;
			for(int i = 0; i < N; i++) {
				int pos = binarySearch(arr[i], 0, length - 1, length);
				dp[pos] = arr[i];
				
				if(pos == length) {
					length++;
				}
			}
			
			System.out.println("#" + t + " " + length);
		}
	}// end Main
	
	private static int binarySearch(long target, int lt, int rt, int size) {
		int res = size;
		while(lt <= rt) {
			int mid = lt + (rt - lt) / 2;
			if(dp[mid] >= target) {
				rt = mid - 1;
				res = mid;
			} else {
				lt = mid + 1;
			}
		}
		
		return res;
	}
}
