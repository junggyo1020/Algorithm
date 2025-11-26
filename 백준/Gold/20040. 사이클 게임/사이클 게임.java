import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;
        rank = new int[N];

        // 간선 입력하기
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!union(u, v)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        //사이클 생김
        if(fa == fb) return false;

        if(rank[fa] > rank[fb]) {
            parent[fb] = fa;
        } else if(rank[fa] < rank[fb]) {
            parent[fa] = fb;
        } else {
            parent[fb] = fa;
            rank[fa]++; //높이 증가
        }

        return true;
    }
}
