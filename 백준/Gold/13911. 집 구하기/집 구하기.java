import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int M, x, S, y;
	static HashSet<Integer> mcDonalds, starbucks;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		init();
		int answer = solve();
		System.out.println(answer);
	}

	private static int solve() {
		// 가상의 시작점에서 모든 맥도날드까지의 거리를 0으로 설정
		int[] minDistFromMcdonalds = new int[V+1];
		Arrays.fill(minDistFromMcdonalds, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 모든 맥도날드 위치를 우선순위 큐에 추가 (거리 0)
		for(int m : mcDonalds) {
			minDistFromMcdonalds[m] = 0;
			pq.offer(new Node(m, 0));
		}
		
		// 다익스트라 알고리즘으로 모든 정점까지의 최단 거리 계산
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.w > minDistFromMcdonalds[cur.v]) continue;
			
			for(Node next : list[cur.v]) {
				if(minDistFromMcdonalds[next.v] > minDistFromMcdonalds[cur.v] + next.w) {
					minDistFromMcdonalds[next.v] = minDistFromMcdonalds[cur.v] + next.w;
					pq.offer(new Node(next.v, minDistFromMcdonalds[next.v]));
				}
			}
		}

		// 스타벅스에 대해서도 동일하게 수행
		int[] minDistFromStarbucks = new int[V+1];
		Arrays.fill(minDistFromStarbucks, Integer.MAX_VALUE);
		pq = new PriorityQueue<>();
		
		for(int s : starbucks) {
			minDistFromStarbucks[s] = 0;
			pq.offer(new Node(s, 0));
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.w > minDistFromStarbucks[cur.v]) continue;
			
			for(Node next : list[cur.v]) {
				if(minDistFromStarbucks[next.v] > minDistFromStarbucks[cur.v] + next.w) {
					minDistFromStarbucks[next.v] = minDistFromStarbucks[cur.v] + next.w;
					pq.offer(new Node(next.v, minDistFromStarbucks[next.v]));
				}
			}
		}

		int minTotalDist = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {
			// 주택인 경우에만 (맥도날드나 스타벅스가 아닌 경우)
			if(!mcDonalds.contains(i) && !starbucks.contains(i)) {
				int d1 = minDistFromMcdonalds[i];
				int d2 = minDistFromStarbucks[i];
				
				// 맥세권이면서 스세권인 경우
				if(d1 <= x && d2 <= y) {
					minTotalDist = Math.min(minTotalDist, d1 + d2);
				}
			}
		}

		return minTotalDist == Integer.MAX_VALUE ? -1 : minTotalDist;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		//간선 정보 저장하기!
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
			list[v].add(new Node(u, w));
		}

		//맥도날드의 수와 맥도날드 정점 번호 저장하기
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		mcDonalds = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			mcDonalds.add(Integer.parseInt(st.nextToken()));
		}

		//스타벅스의 수와 스타벅스 정점 번호 저장하기
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		starbucks = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			starbucks.add(Integer.parseInt(st.nextToken()));
		}
	}

	/**
	 * Dijkstra's algorithm을 사용하여 시작 정점에서 모든 정점까지의 최단 거리를 구하는 함수
	 * @param start 시작 정점
	 * @return 각 정점에서 시작 정점까지의 최단 거리를 저장한 배열
	 */
	static int[] dijkstra(int start){
		int[] dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dis[start] = 0;

		while(!pq.isEmpty()){
			Node cur = pq.poll();

			if(dis[cur.v] > cur.w) continue;

			// 현재 정점에서 인접한 모든 정점을 확인하며, 최단 거리를 갱신한다.
			for(Node next : list[cur.v]){
				if(dis[next.v] > dis[cur.v] + next.w){
					dis[next.v] = dis[cur.v] + next.w;
					pq.offer(new Node(next.v, dis[next.v]));
				}
			}
		}

		return dis;
	}


	static class Node implements Comparable<Node> {
		int v, w;
		Node(int v, int w){
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o){
			return Integer.compare(this.w, o.w);
		}
	}
}
