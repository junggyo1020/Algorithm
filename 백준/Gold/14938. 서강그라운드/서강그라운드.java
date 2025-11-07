import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;
    static List<Node>[] list;
    static int[] dis;
    static int answer;

    static class Node implements Comparable<Node> {
        int e, w;
        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int[] items = new int[N+1];
        for(int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        for(int i = 1; i <= N; i++) {
            dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[i] = 0;

            dijkstra(i);

            int sum = 0;
            for(int j = 1; j <= N; j++) {
                if(dis[j] <= M) sum += items[j];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    private static void dijkstra(int x) {
        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(x, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int idx = cur.e;
            int cost = cur.w;

            if(dis[idx] < cost) continue;

            for(Node next : list[idx]) {
                int nextIdx = next.e;
                int nextCost = next.w;

                if(dis[idx] + nextCost < dis[nextIdx]) {
                    dis[nextIdx] = dis[idx] + nextCost;
                    q.offer(new Node(nextIdx, dis[nextIdx]));
                }
            }
        }
    }
}
