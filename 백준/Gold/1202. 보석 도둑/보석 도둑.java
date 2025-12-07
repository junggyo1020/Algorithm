import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel implements Comparable<Jewel> {
	int mass;
	int value;

	public Jewel(int mass, int value) {
		this.mass = mass;
		this.value = value;
	}

	@Override
	public int compareTo(Jewel o) {
		return Integer.compare(this.mass, o.mass);
	}
}

public class Main {

	static int N, K;
	static Jewel[] jewels;
	static int[] bags;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		jewels = new Jewel[N];
		bags = new int[K];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(m, v);
		}

		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		// 1. 가방을 오름차순 정렬
		Arrays.sort(bags);

		// 2. 보석을 무게 오름차순 정렬
		Arrays.sort(jewels);

		// 3. 가격이 높은 순서대로 큐 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		long totalValue = 0; // 정답은 int 범위를 넘을 수 있음 (최대 30만개 * 100만)
		int jewelIndex = 0;

		// 작은 가방부터 하나씩 확인
		for (int i = 0; i < K; i++) {
			while (jewelIndex < N && jewels[jewelIndex].mass <= bags[i]) {
				pq.offer(jewels[jewelIndex].value);
				jewelIndex++;
			}

			if (!pq.isEmpty()) {
				totalValue += pq.poll();
			}
		}

		System.out.println(totalValue);
	}
}