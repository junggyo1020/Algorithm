import java.util.*;
class Solution {
    
    // 문자열 나누기
    private List<String> split(String s, int n){
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < s.length(); i += n){
            int e = i + n;
            if(e > s.length()) e = s.length();
            tokens.add(s.substring(i, e));
        }
        return tokens;
    }
    
    private int compress(String s, int n){
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 0;
        for(String token : split(s, n)){
            if(token.equals(last)){
                count++;
            } else {
                if(count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;
            }
        }
        if(count > 1) sb.append(count);
        sb.append(last);
        return sb.length();
    }
    
    public int solution(String s) {
        // 길이 단이 별로 함수 돌려서 최소값 구하기
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); i++){
            int compressed = compress(s,i);
            if(compressed < min){
                min = compressed;
            }
        }
        return min;
    }
}