import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static PriorityQueue<Long> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			long x = Long.parseLong(br.readLine());
			pq.offer(x);
		}
		
		long totalSum = 0;
		
		while(pq.size() > 1) {
			long tmp1 = pq.poll();
			long tmp2 = pq.poll();
			
			long sum = tmp1 + tmp2;
			
			totalSum += sum;
			
			pq.offer(sum);
		}
		
		System.out.println(totalSum);
	}

}
