import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [D4] 창용 마을 무리의 개수
 * @author 서울_7반_정정교
 * 
 * N명의 사람 (1-N)
 * 관계되어 있으면 하나의 무리
 * 몇 개의 무리가 존재하는지 계산하기
 * -> Union & Find
 */
public class Solution {

	// I/O
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] parent;
	static ArrayList<Integer>[] list;
	
	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if(fa == fb) return;
		
		parent[fb] = fa;
	}
	
	private static void solve() {
		Set<Integer> s = new HashSet<>();
		for(int i = 1; i <= N; i++) {
			s.add(find(i));
		}
		
		sb.append(s.size()).append("\n");
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			input();
			sb.append("#").append(t).append(" ");
			solve();
		}
		System.out.println(sb);
	}

}
