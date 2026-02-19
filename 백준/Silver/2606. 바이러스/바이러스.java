import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        M = Integer.parseInt(br.readLine()); //컴퓨터 쌍의 수

        //인접리스트 초기화
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        //bfs 실행
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1); // 1번 컴퓨터는 바이러스에 걸렸다.
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    ++answer;
                }
            }
        }

        System.out.println(answer);
    }
}