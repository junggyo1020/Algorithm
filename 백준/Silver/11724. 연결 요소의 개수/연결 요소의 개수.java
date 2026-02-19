import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        //연결 요소 개수 구하기
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                ++answer;
                dfs(i);
            }
        }

        //결과 출력
        System.out.println(answer);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for(int next : adj[cur]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}