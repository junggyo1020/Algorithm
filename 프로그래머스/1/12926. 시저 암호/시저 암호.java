class Solution {
    private char push(char c, int n){
        if(!Character.isAlphabetic(c)) return c;
        
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);
        return (char)(offset + position);
    }
    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        // 문자열을 각각의 문자 배열로 변환한다.
        char[] ch = s.toCharArray();
        // 문자열로 이어붙인다.
        for(char c : ch){
            sb.append(push(c,n));
        }
        // 결과를 반환한다.
        return sb.toString();
    }
}