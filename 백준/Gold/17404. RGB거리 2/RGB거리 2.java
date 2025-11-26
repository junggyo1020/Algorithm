import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1_000_004; // 1000*1000

    static int N;
    static int[][] colors;
    static int[][] dp;
    static StringTokenizer st;
    static int answer = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 집의 색상별 비용 저장
        colors = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken()); //R
            colors[i][1] = Integer.parseInt(st.nextToken()); //G
            colors[i][2] = Integer.parseInt(st.nextToken()); //B
        }

//        // 디버깅
//        for(int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(colors[i]));
//        }

        //dp 값 미리 계산
        solveDP();

        //최소 비용 출력
        System.out.println(answer);
    }

    private static void solveDP() {
        dp = new int[N+1][3];

        for(int k = 0; k < 3; k++) {
            for(int i = 0; i < 3; i++) {
                //초기값 (처음 값은 그냥 집의 비용과 같다.)
                if(i==k) dp[1][i] = colors[1][i];
                else dp[1][i] = INF;
            }

            //이후 색상 채워넣기
            for (int i = 1; i < N; i++) {
                dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + colors[i + 1][0];
                dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]) + colors[i + 1][1];
                dp[i + 1][2] = Math.min(dp[i][0], dp[i][1]) + colors[i + 1][2];
            }

//            //디버깅
//            for(int i = 0; i <= N; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }

            //순환 구조 처리하기
            for(int i = 0; i < 3; i++) {
                if(i!=k) answer = Math.min(answer, dp[N][i]);
            }
        }
    }
}
