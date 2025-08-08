import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static int[] arr;
	static PriorityQueue<Long> pq;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			long x = Long.parseLong(br.readLine());
			if(x != 0) pq.offer(x);
			else sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
		}
		System.out.println(sb);
	}
}
