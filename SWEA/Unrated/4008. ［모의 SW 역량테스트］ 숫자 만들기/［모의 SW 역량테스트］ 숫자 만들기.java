import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int n;
    static int MAX, MIN;
    static StringTokenizer st;
    static int[] num, op_counts;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            num = new int[n];
            op_counts = new int[4];
            //1. 연산자 개수 저장
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++){
                op_counts[i] = Integer.parseInt(st.nextToken());
            }
            //2. 수식에 사용되는 숫자 저장
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            //3. MAX, MIN 초기화
            MAX = Integer.MIN_VALUE;
            MIN = Integer.MAX_VALUE;
            //4. dfs() 호출
            dfs(num[0], 1); //sum=num[0]부터 시작, index = 1부터 시작
            //5. 출력
            sb.append("#").append(t).append(" ").append(MAX-MIN).append("\n");
        }
        System.out.println(sb);
    }
    
    //4. dfs() 정의
    private static void dfs(int sum, int index){
        //4-1. 만약 숫자를 모두 연산했다면 값 갱신
        if(index == n) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        //4-2. 연산자 개수만큼 반복
        for(int i = 0; i < 4; i++){
            if(op_counts[i] <= 0) continue;
            op_counts[i]--;

            switch(i){
                case 0: dfs(sum + num[index], index + 1); break;
                case 1: dfs(sum - num[index], index + 1); break;
                case 2: dfs(sum * num[index], index + 1); break;
                case 3: dfs(sum / num[index], index + 1); break;
            }

            op_counts[i]++;
        }
    }
}
