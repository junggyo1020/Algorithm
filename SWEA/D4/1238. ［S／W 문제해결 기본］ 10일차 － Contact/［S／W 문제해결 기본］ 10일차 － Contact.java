import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, S; //데이터의 길이, 시작점
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	static final int SIZE = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			list = new ArrayList[SIZE+1];
			for(int i = 0; i <= SIZE; i++) {
				list[i] = new ArrayList<>();
			}
			
			int MAX = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				MAX = Math.max(MAX, Math.max(from, to)); //가장 큰 번호의 노드 번호 구하기
				list[from].add(to);
			}
			
			visited = new boolean[MAX+1];
			
			//그래프 탐색(bfs)
			List<Integer> last = new ArrayList<>(); 
			Queue<Integer> q = new LinkedList<>();
			q.offer(S);
			visited[S] = true;
				
			while(!q.isEmpty()) {
				int length = q.size();
				last.clear();
				
				for(int j = 0; j < length; j++) {
					int current = q.poll();
					last.add(current);
					for(int next : list[current]) {
						if(!visited[next]) {
							q.offer(next);
							visited[next] = true;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(Collections.max(last)).append("\n");
		}
		System.out.println(sb);
	}

}
