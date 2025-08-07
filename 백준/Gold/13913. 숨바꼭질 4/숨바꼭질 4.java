import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int[] time, parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		parent = new int[100001];
		
		Arrays.fill(time, -1);
		Arrays.fill(parent, -1);
		
		bfs(n);
		
	}
	
	// 매개변수 이름을 'k'에서 'startNode'로 변경
	private static void bfs(int startNode) { 
	    Queue<Integer> q = new LinkedList<>();
	    q.offer(startNode);
	    time[startNode] = 0;
	    parent[startNode] = startNode;

	    while(!q.isEmpty()) {
	        int cur = q.poll();
	        
	        // 이제 전역 변수인 도착점 k와 올바르게 비교합니다.
	        if(cur == k) { 
	            print();
	            return;
	        }

	        int[] nextNode = {cur - 1, cur + 1, cur * 2};
	        for(int next : nextNode) {
	            if(next < 0 || next > 100000 || time[next] != -1) continue;
	            q.offer(next);
	            time[next] = time[cur] + 1;
	            parent[next] = cur;
	        }
	    }
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(time[k]).append('\n');
		
		ArrayDeque<Integer> path = new ArrayDeque<>();
		int num = k;
		while(num!=n) {
			path.offer(num);
			num = parent[num];
		}
		path.offer(n);
		
		while(!path.isEmpty()) {
			sb.append(path.pollLast()).append(" ");
		}
		System.out.println(sb);
	}

}
