import java.util.*;
class Solution {
    
    private static final int[][] RULES = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };
    
    public int[] solution(int[] answers) {
        List<Integer> results = new ArrayList<>();
        int[] correct_counts = new int[3];
        int max_cnt = 0;
        // 학생별 맞힌 정답 개수 세기
        for(int student = 0; student < 3; student++){
            int cnt = 0;
            int index = RULES[student].length;
            for(int problem = 0; problem < answers.length; problem++){
                int answer = RULES[student][problem % index];
                if(answer == answers[problem]){
                    cnt++;
                }
            }
            correct_counts[student] = cnt;
            if(max_cnt < cnt) max_cnt = cnt;
        }
        
        // 최대 맞힌 개수 같은 학생 모두 출력
        for(int i = 0; i < 3; i++){
            if(max_cnt == correct_counts[i]){
                results.add(i);
            }
        }
        
        return results.stream().mapToInt(i -> i+1).toArray();
    }
}