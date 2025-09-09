import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		//투 포인터
		int res = 0; // 합이 M이 되는 개수
		int sum = 0; // 누적합
		int s = 0; // 시작 포인터
		for (int e = 0; e < N; e++) { //확장
			sum += nums[e];
			while(sum >= M){ //축소
				if(sum == M) res++;
				sum -= nums[s++];
			}
		}

		System.out.println(res);
	}
}
