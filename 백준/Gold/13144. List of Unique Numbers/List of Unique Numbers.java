import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static Set<Integer> hS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		hS = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int lt = 0;
		int rt;
		long count = 0;
		for(rt = 0; rt < N; rt++) {
			int num = numbers[rt];
			//만약 같은 수가 여러 번 등장했다면
			while(hS.contains(num)) {
				hS.remove(numbers[lt]);
				lt++;

				//종료조건
				if(lt >= N) break;
			}

			hS.add(num);
			count += (rt - lt + 1);
		}

		System.out.println(count);
	}
}
