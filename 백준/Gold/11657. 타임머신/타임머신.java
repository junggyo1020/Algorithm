import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 1_000_000_000;
	static int N, M;
	static long[] dis;
	static ArrayList<Edge> graph;

	static class Edge {
		int v, w, cost;

		Edge(int v, int w, int cost) {
			this.v = v;
			this.w = w;
			this.cost = cost;
		}
	}

	private static boolean BellmanFord(int start) {
		//1. 초기화
		dis = new long[N+1];
		Arrays.fill(dis, INF);
		dis[1] = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Edge edge = graph.get(j);

				if(dis[edge.v] != INF && dis[edge.w] > dis[edge.v] + edge.cost) {
					dis[edge.w] = dis[edge.v] + edge.cost;
				}
			}
		}

		//3. 음수 가중치 확인
		for(int i = 0; i < M; i++) {
			Edge edge = graph.get(i);

			if(dis[edge.v] != INF && dis[edge.w] > dis[edge.v] + edge.cost) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();

		//0. 간선 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.add(new Edge(v, w, cost));
		}

		//벨만-포드
		StringBuilder sb = new StringBuilder();
		if(BellmanFord(1)){
			for(int i = 2; i <= N; i++) {
				if(dis[i] == INF) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dis[i]).append("\n");
				}
			}
		} else {
			sb.append(-1).append("\n");
		}

		System.out.println(sb);
	}
}
