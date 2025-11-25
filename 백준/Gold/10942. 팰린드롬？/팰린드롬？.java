import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; // 1-based index 사용
        dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. DP 테이블 채우기
        solveDP();

        // 3. 질문 처리
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(dp[s][e]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    private static void solveDP() {
        // 1) 길이 1인 경우 (자기 자신)
        for(int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 2) 길이 2인 경우 (두 수가 같으면 true)
        for(int i = 1; i <= N - 1; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }
        }

        // 3) 길이 3 이상인 경우
        // length: 구하려는 구간의 길이 (2는 이미 했으므로 3개짜리부터 N개짜리까지)
        // i: 시작 인덱스
        for(int length = 2; length < N; length++) {
            for(int i = 1; i <= N - length; i++) {
                int j = i + length;

                // 양 끝이 같고, 그 사이(속)가 팰린드롬이면 true
                if(arr[i] == arr[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
    }
}