import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
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

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];
        for(int i = 1; i <= V; i++) parent[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, w));
        }

        int useEdge = 0;
        int resultCost = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                resultCost += edge.weight;
                useEdge++;

                if(useEdge == V-1) break;
            }
        }
        System.out.println(resultCost);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa == fb) return;
        
        if(rank[fa] > rank[fb]) {
            parent[fb] = fa;
        } else if(rank[fa] < rank[fb]) {
            parent[fa] = fb;
        } else {
            parent[fb] = fa;
            rank[fa]++;
        }
    }
}
