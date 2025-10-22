import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int minTime = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //수빈
        K = Integer.parseInt(st.nextToken()); //동생
        visited = new boolean[100001];

        if(N == K) {
            System.out.println(0);
            return;
        }

        bfs(N); // dfs(현재 위치)

        System.out.println(minTime);
    }

    private static void bfs(int pos) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(pos);
        visited[pos] = true;
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int cur = q.poll();

                if(cur == K) {
                    minTime = time;
                    return;
                }

                int[] nextPos = {cur * 2, cur + 1, cur - 1};
                for(int next : nextPos) {
                    if(next >= 0 && next <= 100000 && !visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            time++;
        }
    }
}
