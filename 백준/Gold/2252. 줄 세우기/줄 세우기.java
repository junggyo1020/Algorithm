import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		answer = new ArrayList<>();
		indegree = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			indegree[b]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}

		while(!q.isEmpty()) {
			int cur = q.poll();
			answer.add(cur);

			for(int next : adj[cur]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		for(int x : answer) {
			sb.append(x).append(" ");
		}
		sb.append("\n");

		System.out.println(sb);
	}
}
