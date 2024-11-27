import java.util.*;

class Solution {
    
    private int compress(String s, int length){
        StringBuilder sb = new StringBuilder();
        // 개수 만큼 나뉘어진 token으로 비교해서 압축 진행하기
        String last = ""; // 비교를 위한 이전 token 선언
        int count = 0;
        for(String token : split(s, length)){
            if(token.equals(last)) count++;
            else {
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
    
    private List<String> split(String s, int length){
        List<String> tokens = new ArrayList<>();
        for(int startIdx = 0; startIdx < s.length(); startIdx += length){
            int endIdx = startIdx + length;
            if(endIdx > s.length()) endIdx = s.length();
            tokens.add(s.substring(startIdx, endIdx));
        }
        
        return tokens;
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length = 1; length <= s.length(); length++){
            int compressed = compress(s, length);
            // 최소 길이 구하는 공식
            if(min > compressed){
                min = compressed;
            }
        }
        return min;
    }
}