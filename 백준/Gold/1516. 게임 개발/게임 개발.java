import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        int[] time = new int[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int tmp;
            while ((tmp = Integer.parseInt(st.nextToken())) != -1) {
                list[tmp].add(i);
                indegree[i]++;
            }
        }

        //(1) indegree[i] = 0인 녀석들 찾기
        Queue<Integer> q = new ArrayDeque<>();
        int[] resultTime = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                resultTime[i] = time[i];
            }
        }

        //(2) 반복
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : list[cur]) {
                resultTime[next] = Math.max(resultTime[next], resultTime[cur]);
                indegree[next]--;
                if(indegree[next] == 0) {
                    resultTime[next] = resultTime[next] + time[next];
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(resultTime[i]).append("\n");
        }
        System.out.println(sb);
    }
}
