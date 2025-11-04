import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] money;
	static int[] parent;

	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if(rootX == rootY) return;

		if(money[rootX] < money[rootY]) {
			parent[rootY] = rootX;
		} else {
			parent[rootX] = rootY;
		}
	}

	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //학생 수
		M = Integer.parseInt(st.nextToken()); //친구관계 수
		K = Integer.parseInt(st.nextToken()); //가지고 있는 돈
		money = new int[N+1]; //각각 학생들이 원하는 친구비
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		//초기화 (make-set)
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		//친구 관계 확인하기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		int totalCost = 0;

		for(int i = 1; i <= N; i++) {
			if(parent[i] == i) {
				totalCost += money[i];
			}
		}

		if(totalCost <= K) {
			System.out.println(totalCost);
		} else {
			System.out.println("Oh no");
		}
	}
}
