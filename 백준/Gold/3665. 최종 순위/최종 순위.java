import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static StringTokenizer st;
    static int[] numbers;
    static boolean[][] check;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            numbers = new int[N];
            check = new boolean[N+1][N+1];
            indegree = new int[N+1];
            for(int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    int start = numbers[i];
                    int end = numbers[j];
                    check[start][end] = true;
                    indegree[end]++;
                }
            }

            int M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(check[a][b]) {
                    check[a][b] = false;
                    indegree[b]--;
                    check[b][a] = true;
                    indegree[a]++;
                } else {
                    check[b][a] = false;
                    indegree[a]--;
                    check[a][b] = true;
                    indegree[b]++;
                }
            }

            //위상정렬
            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= N; i++) {
                if(indegree[i] == 0) q.offer(i);
            }

            boolean isAmbiguous = false; //확실한 순위를 모를 때
            List<Integer> result = new ArrayList<>();
            while(!q.isEmpty()){
                if(q.size() > 1) isAmbiguous = true;
                int cur = q.poll();
                result.add(cur);
                for(int i = 1; i <= N; i++) {
                    if(check[cur][i]) {
                        indegree[i]--;
                        if(indegree[i] == 0) {
                            q.offer(i);
                        }
                    }
                }
            }

            if(isAmbiguous) {
                sb.append("?").append("\n");
                continue;
            }

            if(result.size() != N) {
                sb.append("IMPOSSIBLE").append("\n");
                continue;
            }

            for(int x : result) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } //end TestCase
        System.out.println(sb);
    }
}
