import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D4_장훈이의 높은 선반
 * 목표: 높이가 B이상인 탑 중에서 높이가 가장 낮은 탑 구하기
 * 입력: 
 * - T <= 10
 * - 1 <= N <= 20, 1 <= B <= S(최대 200_000)
 * - 1 <= height[] <= 10_000
 */
public class Solution {

    static StringTokenizer st;
    static int N, B;
    static int[] heights;
    static int MIN;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            //#1. N, B 입력
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            //#2. 각 점원의 키 정보 입력
            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            
            //#3. N = 20 이므로 완탐가능 2^20 ~ 100만
            MIN = Integer.MAX_VALUE;
            dfs(0, 0); //(sum, index)

            //5. 결과 출력
            sb.append("#").append(t).append(" ").append(MIN).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int sum, int index){
        //#4. 종료조건
        if(index == N) {
            if(sum >= B) MIN = Math.min(MIN, sum-B);
            return;
        } else {
            dfs(sum + heights[index], index+1); //해당 사람 포함
            dfs(sum, index + 1); //해당 사람 미포함
        }
    }
}
