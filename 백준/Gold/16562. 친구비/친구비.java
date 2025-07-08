import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, M, K;
    static int[] cost, parent;

    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) return;
        if (cost[fa] < cost[fb]) {
            parent[fb] = fa;
        } else {
            parent[fa] = fb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        cost = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        long totalCost = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) { //하나의 무리의 최소 친구비
                totalCost += cost[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalCost <= K ? totalCost : "Oh no");

        System.out.println(sb);
    }
}