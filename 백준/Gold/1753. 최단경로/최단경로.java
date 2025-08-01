import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v, cost;
		
		Node(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
	}
	
	static ArrayList<Node>[] list;
	static boolean[] visited; //방문여부 체크
	static int[] dis; //각 노드별 최소거리 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		visited = new boolean[v+1];
		dis = new int[v+1];
		list = new ArrayList[v+1];
		
		for(int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int indexU = Integer.parseInt(st.nextToken());
			int indexV = Integer.parseInt(st.nextToken());
			int indexW = Integer.parseInt(st.nextToken());
			
			list[indexU].add(new Node(indexV, indexW));
		}
		
		dijkstra(k);
		
		for(int i = 1; i <= v; i++) {
			System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		q.add(new Node(start, 0));
		dis[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(!visited[now.v]) {
				visited[now.v] = true; 
			}
			
			for(Node next : list[now.v]) {
				if(!visited[next.v] && dis[next.v] > now.cost + next.cost) {
					dis[next.v] = now.cost + next.cost; 
					q.add(new Node(next.v, dis[next.v]));
				}
			}
		}
	}
}
