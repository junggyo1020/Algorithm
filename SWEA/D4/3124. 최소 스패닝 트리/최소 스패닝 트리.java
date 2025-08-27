import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int V, E;
	static boolean[] visited;
	static List<Edge>[] list;
	
	static class Edge implements Comparable<Edge>{
		int w;
		long cost;
		Edge(int w, long cost){
			this.w = w;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				list[a].add(new Edge(b,c));
				list[b].add(new Edge(a,c));
			}

			sb.append("#").append(t).append(" ");
			prim(1, V);
		}
		System.out.println(sb);
	}
	
	private static void prim(int start, int n) {
		visited = new boolean[n+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		long total = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.w;
			long cost = edge.cost;
			
			if(visited[v]) continue;
			
			visited[v] = true;
			total += cost;
			
			for(Edge e : list[v]) {
				if(!visited[e.w]) {
					pq.add(e);
				}
			}
		}
		sb.append(total).append("\n");
	}

}
