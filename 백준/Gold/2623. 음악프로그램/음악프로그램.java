import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] indegrees = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for(int j = 0; j < K - 1; j++) {
				int next = Integer.parseInt(st.nextToken());
				indegrees[next]++;
				list[prev].add(next);
				prev = next;
			}
		}

		//위상정렬 (1). indegree가 0인 값들을 큐에 넣는다.
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(indegrees[i] == 0) {
				q.offer(i);
			}
		}

		//위상정렬 (2). 정점 개수 만큼 행위를 반복한다.
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			//(2)-1. queue의 front 원소를 빼서 그 정점에서 나가는 간선 모두 삭제한다.
			//queue가 이미 비었을 경우 -> 사이클 발생 -> 위상정렬 불가
			if(q.isEmpty()) {
				System.out.println(0);
				System.exit(0);
			}
			int num = q.poll();
			res.add(num);

			for(int x : list[num]) {
				indegrees[x]--;
				//(2)-2. 만약 간선을 삭제할 때, indegrees가 0이 되는 정점이 생기면 queue에 삽입한다.
				if(indegrees[x] == 0) q.offer(x);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int x : res) {
			sb.append(x).append("\n");
		}
		System.out.println(sb);
	}
}
