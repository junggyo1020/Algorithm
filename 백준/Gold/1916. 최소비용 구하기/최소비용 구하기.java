import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static ArrayList<Node>[] graph;
	static int[] dis;
	
	static class Node{
		int v, cost;
		
		Node(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		dis = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int indexU = Integer.parseInt(st.nextToken());
			int indexV = Integer.parseInt(st.nextToken());
			int indexW = Integer.parseInt(st.nextToken());
			
			graph[indexU].add(new Node(indexV, indexW));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dis[end]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.offer(new Node(start, 0));
		dis[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if (dis[now.v] < now.cost) {
	            continue;
	        }
			
			for(Node next : graph[now.v]) {
				if(dis[next.v] > now.cost + next.cost) {
					dis[next.v] = now.cost + next.cost;
					q.offer(new Node(next.v, dis[next.v]));
				}
			}
		}
	}
}
