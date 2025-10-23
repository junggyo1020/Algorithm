import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int minTime = Integer.MAX_VALUE;
    static int minCnt;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        if(N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Arrays.fill(visited, -1);
        bfs(N); //N번 위치에서 시작

        System.out.println(minTime);
        System.out.println(minCnt);
    }

    private static void bfs(int pos) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(pos);
        visited[pos] = 0; //시작점은 0초
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            if(minTime < time) return;

            for(int s = 0; s < size; s++) {
                int cur = q.poll();

                if(cur == K) {
                    minTime = time;
                    minCnt++;
                    continue;
                }

                int[] nextPos = {cur * 2, cur + 1, cur - 1};
                for(int next : nextPos){
                    if(next >= 0 && next <= 100000){
                        if(visited[next] == -1 || visited[next] == time+1){
                            visited[next] = time + 1;
                            q.offer(next);
                        }
                    }
                }
            }
            time++;
        }
    }
}