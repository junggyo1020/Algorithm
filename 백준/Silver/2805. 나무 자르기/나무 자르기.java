import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int lo = -1, hi = 2_000_000_000;
		
		while(lo + 1 < hi) {
			int mid = lo - (lo - hi) / 2;
			
			if(isCheck(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(lo);
	}
	
	private static boolean isCheck(int num) {
		long sum = 0;
		for(int x : arr) {
			if(x > num) {
				sum += x - num;
			}
		}
		return sum >= M;
	}
}
