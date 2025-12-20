import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static ArrayList<Long> list;

	private static void solution() {
		list = new ArrayList<>();

		for(long i = 1; i*i <= N; i++) {
			if(N % i == 0) {
				list.add(i);

				if(i*i != N) {
					list.add(N/i);
				}
			}
		}

		//정렬
		Collections.sort(list);

		//출력
		long result = list.size() >= K ? list.get(K-1) : 0L;
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		//N개의 약수 모두 구하기
		solution();
	}
}
