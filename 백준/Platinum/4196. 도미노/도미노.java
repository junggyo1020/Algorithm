import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * SCC(Stringly Connected Component 유형
 */
public class Main {

	static StringTokenizer st;
	static int N, M; //정점과 간선의 개수
	static ArrayList<Integer>[] adj;
	static int[] dfsn;
	static int nodeCounter, sccCounter;
	static Stack<Integer> stack;
	static boolean[] finished;
	static ArrayList<ArrayList<Integer>> sccList;
	static int[] sccId;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 초기화 단계
			adj = new ArrayList[N];
			dfsn = new int[N];
			stack = new Stack<>();
			finished = new boolean[N];
			sccList = new ArrayList<>();
			sccId = new int[N];
			nodeCounter = 0;
			sccCounter = 0;

			// 인접리스트 초기화
			for(int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}

			//간선 입력 받기
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				adj[u].add(v);
			}

			//모든 정점에 대해 DFS 순회
			for(int i = 0; i < N; i++) {
				if(dfsn[i] == 0) {
					dfs(i);
				}
			}

			//Step 2. 진입차수를 계산해야 한다.
			int[] indegree = new int[sccCounter];
			for(int u = 0; u < N; u++) {
				for(int v : adj[u]) {
					if(sccId[u] != sccId[v]) {
						indegree[sccId[v]]++;
					}
				}
			}

			int answer = 0;
			for(int i = 0; i < sccCounter; i++) {
				if(indegree[i] == 0) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int cur) {
		dfsn[cur] = ++nodeCounter;
		stack.push(cur);

		int result = dfsn[cur];

		for(int next : adj[cur]) {
			if(dfsn[next] == 0) {
				result = Math.min(result, dfs(next));
			} else if(!finished[next]) {
				result = Math.min(result, dfsn[next]);
			}
		}

		if(result == dfsn[cur]) {
			ArrayList<Integer> curScc = new ArrayList<>();
			while(true) {
				int t = stack.pop();
				finished[t] = true;
				curScc.add(t);
				sccId[t] = sccCounter;

				if(t == cur) break;
			}

			sccList.add(curScc);
			sccCounter++;
		}

		return result;
	}
}
