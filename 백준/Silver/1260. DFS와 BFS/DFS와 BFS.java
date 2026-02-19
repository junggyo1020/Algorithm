import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M, V;
    static List<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        //인접리스트 초기화
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        //간선 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        //정점 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        //dfs 진행
        dfs(V);
        System.out.println(sb);

        //bfs 진행
        visited = new boolean[N+1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(" ");
        for(int next : adj[cur]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    private static void bfs(int cur) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for(int next : adj[x]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}