import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        //초기 문자열
        for(int i = 0; i < N; i++) {
            dq.offer(s.charAt(i));
        }
        
        //초기 문자열 올바른 괄호인지 확인
        if(checkBracket(dq)) answer++;
        
        for(int i = 0; i < N - 1; i++) {
            //문자열 회전
            char node = dq.poll();
            dq.offer(node);
            
            //올바른 괄호 확인
            if(checkBracket(dq)) answer++;
        }
        
        return answer;
    }
    
    private static boolean checkBracket(ArrayDeque<Character> dq) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(Character ch : dq) {
            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else {
                if(st.isEmpty()) return false;
                if(ch == ')' && st.peek() == '(') st.pop();
                else if(ch == ']' && st.peek() == '[') st.pop();
                else if(ch == '}' && st.peek() == '{') st.pop();
                else return false;
            }
        }
        
        return st.isEmpty();
    }
}