import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> obj = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			obj.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(obj, Collections.reverseOrder()); // 8 4 4 1 1

		//충전에 필요한 시간이 많은 것부터 넣자.
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			pq.offer(0L); //끝나는 시간
		}

		for(int x : obj) {
			long time = pq.poll(); //콘센트 중 가장 빨리 사용가능한 시간
			pq.offer(x + time);
		}

		Long endTime = -1L;
		while(!pq.isEmpty()) {
			endTime = pq.poll();
		}
		//
		// Long endTime = -1L;
		// for(int i = 0; i < M; i++) {
		// 	endTime = Math.max(endTime, pq.poll());
		// }

		System.out.println(endTime);

	}
}
