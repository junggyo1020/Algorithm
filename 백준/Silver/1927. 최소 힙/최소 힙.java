import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static int[] arr;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) add(x);
			else remove();
		}
	}
	
	private static void add(int x) {
		pq.offer(x);
	}
	
	private static void remove() {
		if(pq.isEmpty()) System.out.println(0);
		else System.out.println(pq.poll());
	}
}
