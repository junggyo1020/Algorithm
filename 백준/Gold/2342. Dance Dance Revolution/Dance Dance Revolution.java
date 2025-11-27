import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> moves;
    static int[][][] dp;
    static final int INF = 100_000_000; // 충분히 큰 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        moves = new ArrayList<>();

        // 1. 입력 받기
        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            moves.add(n);
        }
        
        if (moves.isEmpty()) {
            System.out.println(0);
            return;
        }

        int N = moves.size();

        // 2. DP 배열 초기화
        // dp[단계][왼발위치][오른발위치]1
        dp = new int[N + 1][5][5];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        // 초기 상태: 0단계, 왼발 0, 오른발 0, 비용 0
        dp[0][0][0] = 0;

        // 3. DP 수행
        for (int i = 0; i < N; i++) {
            int target = moves.get(i); // 이번에 밟아야 할 발판

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    // 도달할 수 없는 상태면 스킵
                    if (dp[i][l][r] == INF) continue;

                    // 1) 왼발을 움직여서 target으로 가는 경우
                    int costL = getCost(l, target);
                    // 왼발이 이동하므로 다음 상태는 [target][r]
                    dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], dp[i][l][r] + costL);

                    // 2) 오른발을 움직여서 target으로 가는 경우
                    int costR = getCost(r, target);
                    // 오른발이 이동하므로 다음 상태는 [l][target]
                    dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], dp[i][l][r] + costR);
                }
            }
        }

        // 4. 결과 출력
        // 마지막 단계(N)에서 모든 왼발/오른발 조합 중 최소 비용 찾기
        int answer = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[N][l][r]);
            }
        }

        System.out.println(answer);
    }

    // 이동 비용 계산 함수
    private static int getCost(int from, int to) {
        // 1. 같은 지점을 한 번 더 누름
        if (from == to) return 1;

        // 2. 중앙(0)에서 이동
        if (from == 0) return 2;

        // 3. 반대편으로 이동 (1<->3, 2<->4)
        // 차이가 2면 반대편임
        if (Math.abs(from - to) == 2) return 4;

        // 4. 인접한 곳으로 이동
        return 3;
    }
}