import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static PriorityQueue<Long> pq;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>((o1, o2) -> {
			long abs1 = Math.abs(o1);
			long abs2 = Math.abs(o2);
			
			if(abs1 == abs2) return Long.compare(o1, o2);
			
			return Long.compare(abs1, abs2);
		});
		
		for(int i = 0; i < n; i++) {
			long x = Integer.parseInt(br.readLine());
			if(x != 0) pq.offer(x);
			else sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
		}
		System.out.println(sb);
	}
}
