import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int N, M, A, B, answer = -1;
    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[A] = true;
        dfs(A, 0); //pos, depth

        System.out.println(answer);
    }

    private static void dfs(int pos, int depth) {
        if (pos == B) {
            answer = depth;
            return;
        }
        for (int x : list.get(pos)) {
            if (!visited[x]) {
                visited[x] = true;
                dfs(x, depth + 1);
            }
        }
    }
}