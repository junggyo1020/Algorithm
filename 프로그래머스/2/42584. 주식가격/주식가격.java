import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            while(!dq.isEmpty() && prices[dq.peek()] > prices[i])             {
                answer[dq.peek()] = i - dq.peek();
                dq.pop();
            }
            dq.push(i);
        }
        
        for(int x : dq) {
            answer[x] = (n-1) - x;
        }
        
        return answer;
    }
}