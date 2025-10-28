import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringTokenizer st;

	static class Room implements Comparable<Room>{
		int s, e;
		Room(int s, int e) {
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
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			spq.offer(new Room(s, e));
		}

		PriorityQueue<Integer> epq = new PriorityQueue<>();
		epq.offer(spq.poll().e);

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
