import java.util.*;

class Solution {
    
    private int compress(String source, int length){
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 0;
        for(String token : split(source, length)){
            //압축 문자열 구성
            if(token.equals(last)){
                count++;
            } else {
                if(count > 1){sb.append(count);}
                    sb.append(last);
                    last = token;
                    count = 1;
            }
        }
            if(count > 1) sb.append(count);
            sb.append(last);   
        // 압축한 문자열의 길이 반환
        return sb.length();
    }
    
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        // source를 length만큼 잘라서 tokens리스트에 추가
        for(int i = 0; i < source.length(); i += length){
            int end = i + length;
            if(end > source.length()) end = source.length();
            // 문자열을 i부터 잘라 tokens리스트에 추가
            tokens.add(source.substring(i,end));
        }
        return tokens;
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); i++){
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, i);
            if(compressed < min){
                min = compressed;
            }
        }
        return min;
    }
}