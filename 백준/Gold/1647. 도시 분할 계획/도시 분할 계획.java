import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int maxCost = Integer.MIN_VALUE;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, w));
        }

        int count = 0;
        int result = 0;

        parent = new int[N+1];
        rank = new int[N+1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            //간선을 넣을 수 있는지 확인
            if(find(cur.from) != find(cur.to)){
                //간선 넣고
                union(cur.from, cur.to);
                count++;
                //비용 추가하고
                result += cur.weight;
                maxCost = Math.max(maxCost, cur.weight);

                //간선 다 넣었으면
                if(count == N-1) {
                    //비용 출력한다.
                    System.out.println(result - maxCost); //가장 비싼 간선 하나만 없애면 됨
                }
            }
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa == fb) return;

        if(rank[fa] < rank[fb]) {
            parent[fa] = fb;
        }
        else if(rank[fb] < rank[fa]) {
            parent[fb] = fa;
        }
        else {
            parent[fb] = fa;
            rank[fa]++;
        }
    }
}
