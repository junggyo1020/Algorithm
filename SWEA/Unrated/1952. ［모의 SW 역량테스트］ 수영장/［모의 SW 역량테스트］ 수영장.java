import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int[] cost, month;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            //1. 비용저장하기
            cost = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                cost[i] = Integer.parseInt(st.nextToken());
            }

            //2. 12개월 이용계획 저장하기
            month = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++){
                month[i] = Integer.parseInt(st.nextToken());
            }

            //3. dp 정의하기: dp[i] = i개월까지의 최소 지출금액
            int[] dp = new int[13];
            
            //4. 초기화(1일권 금액)
            for(int i = 1; i <= 12; i++){ //1일씩 or 1개월 한번에 가격 비교
                dp[i] = dp[i-1] + Math.min(month[i] * cost[0], cost[1]);

                //5. 1개월 or 3개월 가격 비교
                if(i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i-3] + cost[2]);
                }
            }

            //6. 1년 가격과 최종 가격 비교
            dp[12] = Math.min(dp[12], cost[3]);
            
            //7. 결과 출력
            sb.append("#").append(t).append(" ").append(dp[12]).append("\n");
        }
        System.out.println(sb);
    }
}
