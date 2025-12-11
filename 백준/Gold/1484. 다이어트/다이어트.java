import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int G;
	static final int MAX = 50_000;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine()); //100_000보다 작거나 같은 자연수
		list = new ArrayList<>();

		/**
		 * 예시
		 * G = 15
		 * 성원 * 성원 - 이전 무게 * 이전 무게
		 * rt*rt - lt*lt = G 여야 한다.
		 */
		// 빼기를 구해야 하므로 양끝 기준으로 구한다.
		int lt = 1;
		int rt = 2;
		while(rt <= MAX) {
			long sum = (long)rt*rt - (long)lt*lt;
			if(sum == G) {
				list.add(rt);
				rt++;
				lt++;
			} else if(sum > G) {
				lt++;
			} else {
				rt++;
			}

			if(lt >= MAX) break;
		}

		//결과 출력
		StringBuilder sb = new StringBuilder();
		for(int x : list) {
			sb.append(x).append("\n");
		}

		System.out.println(list.isEmpty() ? -1 : sb);
	}
}
