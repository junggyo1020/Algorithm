import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringTokenizer st;

	static class Room implements Comparable<Room> {
		int n, s, e;
		Room(int n, int s, int e) {
			this.n = n;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Room o) {
			if(this.s == o.s) return Integer.compare(this.e, o.e);
			return Integer.compare(this.s, o.s);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Room> spq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			spq.offer(new Room(a, b, c));
		}

		Room init = spq.poll();
		PriorityQueue<Integer> epq = new PriorityQueue<>();
		epq.offer(init.e);

		while(!spq.isEmpty()) {
			Room cur = spq.poll();
			if(cur.s >= epq.peek()) {
				epq.poll();
				epq.offer(cur.e);
			} else {
				epq.offer(cur.e);
			}
		}

		System.out.println(epq.size());
	}
}
