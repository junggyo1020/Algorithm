import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, W;
    static int[] times, indegree, dp;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        //0. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //건물의 개수
            K = Integer.parseInt(st.nextToken()); //건설규칙 개수

            times = new int[N+1];
            adj = new ArrayList[N+1]; // 선행 건설 건물
            indegree = new int[N+1];
            dp = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<>();
            }

            // 건설 순서 저장
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b); //a를 b전에 건설해야 한다.
                indegree[b]++;
            }

            // 건설해야 할 건물의 번호
            W = Integer.parseInt(br.readLine());

            topologySort();

            System.out.println(dp[W]);
        }
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();

        //Step 1. 진입 차수 0인 지점 찾기
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                dp[i] = times[i];
            }
        }

        //Step 2. 위상 정렬 수행
        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == W) break;

            for(int next : adj[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + times[next]);
                indegree[next]--;

                //Step 3
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
