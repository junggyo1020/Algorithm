import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        //선언부
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        //구현부
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && numbers[dq.peek()] < numbers[i]) {
                int top = dq.pop();
                answer[top] = numbers[i];
            }
            dq.push(i);
        }
        
        return answer;
    }
}