import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int V, E;
	static List<Edge> edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;
		Edge(int from, int to, long weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<>();	
			parents = new int[V+1];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				edgeList.add(new Edge(a, b, c));
			}
			
			Collections.sort(edgeList);
			
			makeSet();
			long result = 0;
			int cnt = 0;
			
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(++cnt == V-1) break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	//==== private ====
	private static void makeSet() {
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if(fa == fb) return false;
		
		if(fa > fb) {
			parents[fb] = fa;
		} else {
			parents[fa] = fb;
		}
		
		return true;
	}

}
