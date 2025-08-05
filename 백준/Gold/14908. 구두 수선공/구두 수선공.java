import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node>{
		int id, t, cost;
		
		Node(int id, int t, int cost){
			this.id = id;
			this.t = t;
			this.cost = cost;
		}
		
		/**
		 * 교차 곱셈 사용하기
		 * => Greedy : "작업 시간 대비 보상금 비율이 가장 큰 작업이 가장 우선순위이다"
		 */
		@Override
		public int compareTo(Node o) {
			if(o.cost * this.t == this.cost * o.t) return this.id - o.id;
			return o.cost * this.t - this.cost * o.t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Node(i, t, cost));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(Node x : list) {
			sb.append(x.id + " ");
		}
		
		System.out.println(sb);
	}
}
