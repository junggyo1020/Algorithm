import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static final int N = 9;
	static int[] heights;
	static ArrayList<Integer> results;

	private static void dfs(int cnt, int start, int sum) {

		if(sum > 100) return;

		//일곱 난쟁이를 다 뽑은 경우
		if(cnt == 7) {
			if(sum == 100) {
				//일곱난쟁이를 오름차순으로 정렬
				Collections.sort(results);
				for(int x : results) {
					System.out.println(x);
				}
				System.exit(0);
			}
			return;
		}
		else {
			for (int i = start; i < N; i++) {
				results.add(heights[i]);
				dfs(cnt + 1, i + 1, sum + heights[i]);
				results.remove(results.size() - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//우선 아홉 난쟁이의 키를 모두 저장한다.
		heights = new int[N];
		for(int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}

		//9명 중 7명의 일곱난쟁이 뽑기 (순서 상관 X) -> 조합
		results = new ArrayList<>();
		dfs(0, 0, 0);
	}
}
