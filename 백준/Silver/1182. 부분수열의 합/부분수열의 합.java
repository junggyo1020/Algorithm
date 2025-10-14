import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 */
public class Main {

	static int N, S;
	static int[] nums;
	static boolean[] selected;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		selected = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, selected);

		if (S == 0) {
			answer--;
		}

		System.out.println(answer);
	}

	private static void dfs(int start, boolean[] selected){
		if(start == N) {
			int sum = 0;
			for(int i = 0; i < N; i++){
				if(selected[i]){
					sum += nums[i];
				}
			}

			if(sum == S) answer++;
			return;
		}

		selected[start] = true;
		dfs(start + 1, selected);
		selected[start] = false;
		dfs(start + 1, selected);
	}
}
