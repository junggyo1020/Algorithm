import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] num;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		//연산자 개수
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, num[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int cnt, int sum) {
		//연산자 모두 골랐으므로
		if(cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		//값 계산하기
		for(int i = 0; i < 4; i++) {
			if(operator[i] == 0) continue;
			operator[i]--;
			switch (i) {
				case 0:
					dfs(cnt + 1, sum + num[cnt]);
					break;
				case 1:
					dfs(cnt + 1, sum - num[cnt]);
					break;
				case 2:
					dfs(cnt + 1, sum * num[cnt]);
					break;
				case 3:
					if (sum < 0) {
						dfs(cnt + 1, (sum * (-1) / num[cnt]) * (-1));
					} else {
						dfs(cnt + 1, sum / num[cnt]);
					}
					break;
			}
			operator[i]++;
		}
	}
}
