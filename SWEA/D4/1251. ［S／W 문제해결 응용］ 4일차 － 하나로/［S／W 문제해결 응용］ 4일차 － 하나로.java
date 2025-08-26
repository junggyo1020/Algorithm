import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static double E, totalCost;
	static Point[] points;
	static ArrayList<Edge> edgeList;
	static int[] parents;
	
	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double cost;
		
		Edge(int from, int to, double cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
	
	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		String[] strX = br.readLine().split(" ");
		String[] strY = br.readLine().split(" ");
		points = new Point[N];
		parents = new int[N];
		edgeList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			points[i] = new Point(Integer.parseInt(strY[i]), Integer.parseInt(strX[i]));
		}
		E = Double.parseDouble(br.readLine());
	}
	
	static void makeSet() {
		for(int i = 0; i < N; i++) {
			parents[i] = -1;
		}
	}
	
	static int find(int x) {
		if(parents[x] == -1) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int a, int b) {
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
	
	static void solve() {
		//모든 정점들 간의 시작점, 끝점, 거리 구해서 저장하기
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				long dx = points[i].x - points[j].x;
				long dy = points[i].y - points[j].y;
				double cost = E * (dx*dx + dy*dy);
				edgeList.add(new Edge(i, j, cost));
			}
		}
		
		Collections.sort(edgeList);
		
		makeSet();
		totalCost = 0;
		int edgeCnt = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				totalCost += edge.cost;
				if(++edgeCnt == N-1) break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			input();
			solve();
			sb.append(Math.round(totalCost)).append("\n");
		}
		System.out.println(sb);
	}
}