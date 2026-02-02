import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 9999999; // 적당히 큰 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 유저 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수

        int[][] dist = new int[N + 1][N + 1];

        // 1. 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // 2. 친구 관계 입력 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dist[u][v] = dist[v][u] = 1;
        }

        // 3. 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) { // 거쳐가는 노드
            for (int i = 1; i <= N; i++) { // 출발 노드
                for (int j = 1; j <= N; j++) { // 도착 노드
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 4. 케빈 베이컨 수가 가장 작은 사람 찾기
        int minSum = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[i][j];
            }

            if (minSum > sum) {
                minSum = sum;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}