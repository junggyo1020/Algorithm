import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M; //정점과 간선의 수
	static ArrayList<Integer>[] adj; // 인접그래프
	static int[] dfsn;
	static ArrayList<ArrayList<Integer>> sccList;
	static int nodeCounter, sccCounter;
	static Stack<Integer> stack;
	static boolean[] finished;
	static int[] sccId;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while(true){
			while(st == null || !st.hasMoreTokens()) {
				String line = br.readLine();
				if(line == null) return;
				st = new StringTokenizer(line);
			}

			N = Integer.parseInt(st.nextToken());

			if(N == 0) break;

			M = Integer.parseInt(st.nextToken());

			//변수 초기화
			adj = new ArrayList[N];
			dfsn = new int[N];
			sccList = new ArrayList<>();
			nodeCounter = 0;
			sccCounter = 0;
			stack = new Stack<>();
			finished = new boolean[N];
			sccId = new int[N];

			//인접 그래픞 초기화
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}

			//모든 간선 입력
			for (int i = 0; i < M; i++) {
				if(!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
				int A = Integer.parseInt(st.nextToken()) - 1;
				if(!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
				int B = Integer.parseInt(st.nextToken()) - 1;

				adj[A].add(B);
			}

			//모든 정점에 대해 DFS 순회
			for (int i = 0; i < N; i++) {
				if (dfsn[i] == 0) {
					dfs(i);
				}
			}

			//결과 출력 (기존 SCC 찾는 방식)
			// for(ArrayList<Integer> scc : sccList) {
			// 	for(int node : scc) {
			// 		System.out.print((node+1) + " ");
			// 	}
			// 	System.out.println();
			// }

			//결과 출력 (싱크 SCC 유형 - 해당 노드에서 나갈 수 있는 방향이 하나도 없어야 한다.)
			boolean[] hasOutDegree = new boolean[sccCounter];
			for (int u = 0; u < N; u++) {
				for (int v : adj[u]) {
					if (sccId[u] != sccId[v]) {
						hasOutDegree[sccId[u]] = true;
					}
				}
			}

			ArrayList<Integer> sinkNodes = new ArrayList<>();
			for (ArrayList<Integer> scc : sccList) {
				if (scc.isEmpty())
					continue;

				int curSccId = sccId[scc.get(0)]; // 해당 scc에 속하는 아무 노드나 상관 없음

				if (!hasOutDegree[curSccId]) {
					sinkNodes.addAll(scc);
				}
			}

			Collections.sort(sinkNodes);

			StringBuilder sb = new StringBuilder();
			for (int node : sinkNodes) {
				sb.append(node + 1).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}

	private static int dfs(int cur) {
		dfsn[cur] = ++nodeCounter;
		stack.push(cur);

		int result = dfsn[cur]; // SCC 부분의 가장 높은 노드

		for(int next : adj[cur]) {
			if(dfsn[next] == 0) {
				result = Math.min(result, dfs(next));

			} else if(!finished[next]){
				result = Math.min(result, dfsn[next]);
			}
		}

		if(result == dfsn[cur]) { //끝까지 도달한 경우
			ArrayList<Integer> curScc = new ArrayList<>();

			while(true) {
				int t = stack.pop();
				curScc.add(t);
				finished[t] = true;
				sccId[t] = sccCounter;

				if(t == cur) break;
			}

			sccList.add(curScc);
			sccCounter++;
		}

		return result;
	}
}
