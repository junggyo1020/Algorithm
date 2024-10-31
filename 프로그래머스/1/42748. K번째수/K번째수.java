import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < answer.length; i++){
            int[] command = commands[i];
            int s = command[0] - 1;
            int e = command[1];
            int k = command[2] - 1;
            
            // 배열의 특정 구간을 자른다
            int[] sub = Arrays.copyOfRange(array, s, e);
            // 배열을 정렬한다
            Arrays.sort(sub);
            // 배열의 특정 인덱스값을 구한다
            answer[i] = sub[k];
        }
        return answer;
    }
}