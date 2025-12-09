import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Shark> sharks;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] match;

	static class Shark {
		int size, velocity, intel;
		Shark(int size, int velocity, int intel) {
			this.size = size;
			this.velocity = velocity;
			this.intel = intel;
		}

		private boolean equals(Shark o) {
			return this.size == o.size && this.velocity == o.velocity && this.intel == o.intel;
		}
	}

	private static boolean dfs(int u) {
		for(int v : adj[u]) {
			if(visited[v]) continue;
			visited[v] = true;

			if(match[v] == 0 || dfs(match[v])) {
				match[v] = u;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sharks = new ArrayList<>();
		adj = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int velocity = Integer.parseInt(st.nextToken());
			int intel = Integer.parseInt(st.nextToken());
			sharks.add(new Shark(size, velocity, intel));
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				Shark sharkA = sharks.get(i);
				Shark sharkB = sharks.get(j);

				if(sharkA.size >= sharkB.size && sharkA.velocity >= sharkB.velocity && sharkA.intel >= sharkB.intel){
					if(sharkA.equals(sharkB) && i > j) continue;
					adj[i+1].add(j+1);
				}
			}
		}

		int totalMatching = 0;
		match = new int[N+1];
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			if (dfs(i)) {
				totalMatching++;
			}

			visited = new boolean[N+1];
			if(dfs(i)) {
				totalMatching++;
			}
		}

		System.out.println(N - totalMatching);
	}
}
