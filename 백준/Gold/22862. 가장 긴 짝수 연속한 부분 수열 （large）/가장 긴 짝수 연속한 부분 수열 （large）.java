import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 백준 제출 시 class Main

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//선언부
		int lt = 0;
		int rt = 0;
		int len = 0;
		int oddCnt = 0;

		//두 포인터
		for(rt = 0; rt < N; rt++) {
			if(arr[rt] % 2 != 0 ) { //만약 홀수 추가되면
				oddCnt++;
			}

			while(oddCnt > K) {
				if(arr[lt] % 2 != 0) {
					oddCnt--;
				}
				lt++;
			}

			len = Math.max(len, rt - lt + 1 - oddCnt);
		}
		System.out.println(len);
	}
}