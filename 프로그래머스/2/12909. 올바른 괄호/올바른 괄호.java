import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        /**
         * 올바른 괄호 -> 짝짓기 문제 -> 스택
         * '(' 들어오는 경우 -> 스택에 push
         * ')' 들어오는 경우 
         * case1. 스택의 최상단이 '('인 경우 pop
         * case2. 스택의 최상단이 ')'인 경우 false 리턴
        **/
        Stack<Character> st = new Stack<>();
        for(char x : s.toCharArray()){
            if(x == '(') st.push(x);
            else {
                if(!st.isEmpty() && st.peek() == '(') st.pop();
                else return false;
            }
        }
        
        if(!st.isEmpty()) return false;
        return answer;
    }
}