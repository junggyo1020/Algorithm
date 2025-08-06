import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int[] time;
	static PriorityQueue<Node> pq;

	static final int MAX_VALUE = 100000;
	
	static class Node{
		int time, pos;
		
		Node(int time, int pos){
			this.time = time;
			this.pos = pos;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[MAX_VALUE + 1];
		
		Arrays.fill(time, Integer.MAX_VALUE);
		
		dijkstra();
	}
	
	private static void dijkstra() {
		pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		time[n] = 0;
		pq.offer(new Node(0, n));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.time > time[cur.pos]) continue;
			
			//다음 위치, 다음 시간 정의
			int next_pos = -1;
			int next_time = -1;
			
			//순간 이동
			next_pos = cur.pos * 2;
			next_time = cur.time;
			check(next_pos, next_time);
			//전진
			next_pos = cur.pos + 1;
			next_time = cur.time + 1;
			check(next_pos, next_time);
			//후퇴
			next_pos = cur.pos - 1;
			next_time = cur.time + 1;
			check(next_pos, next_time);
		}
		
		System.out.println(time[k]);
	}
	
	private static void check(int next_pos, int next_time) {
		if(next_pos < 0 || next_pos > MAX_VALUE) return;
		if(next_time < time[next_pos]) {
			time[next_pos] = next_time;
			pq.offer(new Node(time[next_pos], next_pos));
		}
	}
}
