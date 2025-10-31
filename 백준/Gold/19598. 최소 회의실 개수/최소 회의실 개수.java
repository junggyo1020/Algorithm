import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static StringTokenizer st;
	static PriorityQueue<Point> spq;

	static class Point implements Comparable<Point> {
		long s, e;

		Point(long s, long e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Point o) {
			if(this.s == o.s) {
				return Long.compare(this.e, o.e);
			}
			return Long.compare(this.s, o.s);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		spq = new PriorityQueue<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			spq.offer(new Point(a, b));
		}

		PriorityQueue<Long> epq = new PriorityQueue<>();
		epq.offer(0L);

		while(!spq.isEmpty()) {
			Point cur = spq.poll();

			//들어올 회의가 기존 회의 끝나기 이전에 들어올 때
			if(cur.s < epq.peek()) {
				//회의실을 늘려야 한다.
				epq.offer(cur.e);
			}
			//들어올 회의가 기존 회의가 끝난 다음 들어올 때
			else {
				epq.poll();
				epq.offer(cur.e);
			}
		}

		System.out.println(epq.size());
	}
}
