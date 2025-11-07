import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//(1) make-set
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a,b);
		}

		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(parent[i] == i) cnt++;
		}

		System.out.println(cnt-1);
	}

	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if(fa == fb) return;

		if(fa > fb) {
			parent[fb] = fa;
		} else {
			parent[fa] = fb;
		}
	}

	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}
