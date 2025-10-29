import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, R, Q;
    static ArrayList<Integer>[] list;
    static int[] size; // 각 노드의 서브트리 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 트리 정점 수
        R = Integer.parseInt(st.nextToken()); // 트리 루트 번호
        Q = Integer.parseInt(st.nextToken()); // 쿼리의 수
        size = new int[N+1];

        // 트리 구성하기
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        dfs(R, -1); //현재 노드, 부모 노드

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            int idx = Integer.parseInt(br.readLine());
            sb.append(size[idx]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cur, int parent) {
        size[cur] = 1;
        for(int next : list[cur]) {
            if(next != parent) {
                dfs(next, cur);
                size[cur] += size[next];
            }
        }
    }
}
