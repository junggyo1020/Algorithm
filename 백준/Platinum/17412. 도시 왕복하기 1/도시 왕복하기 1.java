import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, P;
    static ArrayList<Integer>[] adj;
    static int[][] capacity; // 용량
    static int[][] flow;     // 현재 유량

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 인덱스를 1부터 사용하기 위해 N+1 크기로 할당
        adj = new ArrayList[N + 1];
        capacity = new int[N + 1][N + 1];
        flow = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향으로 간선 추가
            adj[u].add(v);
            adj[v].add(u);

            // u -> v 방향의 용량은 1
            capacity[u][v] = 1;
        }

        int source = 1;
        int sink = 2;
        int totalFlow = 0;

        while (true) {
            int[] parent = new int[N + 1];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();

            parent[source] = source;
            queue.add(source);

            while (!queue.isEmpty() && parent[sink] == -1) {
                int current = queue.poll();
                for (int next : adj[current]) {
                    // 방문하지 않았고, 잔여 용량이 남아있는 경우
                    if (parent[next] == -1 && capacity[current][next] - flow[current][next] > 0) {
                        queue.add(next);
                        parent[next] = current;
                    }
                }
            }

            // 증가 경로가 없으면 종료
            if (parent[sink] == -1) {
                break;
            }

            // 경로가 있으면 유량 흘려보내기
            int pathFlow = 1;
            for (int i = sink; i != source; i = parent[i]) {
                int prev = parent[i];
                flow[prev][i] += pathFlow; // 정방향 유량 증가
                flow[i][prev] -= pathFlow; // 역방향 유량 감소
            }
            
            totalFlow += pathFlow;
        }

        System.out.println(totalFlow);
    }
}