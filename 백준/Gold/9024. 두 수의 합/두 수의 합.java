import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		//0. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			//1. 정수 배열 저장
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			//2. 투 포인터 알고리즘
			Arrays.sort(arr, 0, N);
			long fitValue = Long.MAX_VALUE;
			int maxCnt = 0;
			int lt = 0;
			int rt = N - 1;
			while(lt < rt) {
				long sum = (long)arr[lt] + arr[rt];
				long result = Math.abs(sum - K);
				if(result < fitValue) {
					fitValue = result; //갱신하고
					maxCnt = 1; //개수 초기화
				} else if(result == fitValue) {
					maxCnt++;
				}

				//포인터 갱신
				if (sum > K) {
					rt--;
				} else {
					lt++;
				}
			}

			//3. 출력값 저장
			sb.append(maxCnt).append("\n");
		}
		//4. 출력
		System.out.println(sb);
	}
}
