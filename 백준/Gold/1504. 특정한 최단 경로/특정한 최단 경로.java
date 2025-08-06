import java.io.*;
import java.util.*;

public class Main {
	
	static int n, e;
	static ArrayList<Node>[] list;
	
	static final int INF = 200_000_000;
	
	static class Node implements Comparable<Node> {
		int v, cost;
		
		Node(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[] disFrom1 = dijkstra(1);
		int[] disFromX = dijkstra(x);
		int[] disFromY = dijkstra(y);
		
		//1 > x > y > n
		long path1 = (long)disFrom1[x] + disFromX[y] + disFromY[n];
		
		//1 > y > x > n
		long path2 = (long)disFrom1[y] + disFromY[x] + disFromX[n];
		
		long minPath = Math.min(path1, path2);
		
		if(minPath >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(minPath);
		}
	}
	
	private static int[] dijkstra(int start) {
		//초기설정
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dis = new int[n+1];
		Arrays.fill(dis, INF);
		
		dis[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost > dis[cur.v]) continue;
			
			for(Node next : list[cur.v]) {
				if(dis[next.v] > cur.cost + next.cost) {
					dis[next.v] = cur.cost + next.cost;
					pq.offer(new Node(next.v, dis[next.v]));
				}
			}
		}
		
		return dis;
	}
}