import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int V, E;
	static ArrayList<Integer>[] list;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			indegree = new int[V+1];
			list = new ArrayList[V+1];
			for(int i = 1; i <= V; i++){
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++){
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				indegree[b]++;
			}
			sb.append("#").append(t).append(" ");
			topologicalSort(indegree);
		}
		System.out.println(sb);
	}

	private static void topologicalSort(int[] indegree) {
		Queue<Integer> q = new ArrayDeque<>();
		Queue<Integer> answer = new ArrayDeque<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			answer.add(cur);

			for (int next : list[cur]) {
				indegree[next]--;

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		for (int x : answer) {
			sb.append(x).append(" ");
		}
		sb.append("\n");
	}
}