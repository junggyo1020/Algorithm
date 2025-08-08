import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int n;
	static PriorityQueue<Integer> maxHeap, minHeap;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(maxHeap.size() <= minHeap.size()){
				maxHeap.offer(x);
			} else {
				minHeap.offer(x);
			}
			
			if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int tmp1 = maxHeap.poll();
				int tmp2 = minHeap.poll();
				maxHeap.offer(tmp2);
				minHeap.offer(tmp1);
			}
			
			sb.append(maxHeap.peek()).append('\n');
		}
		System.out.println(sb);
	}

}
