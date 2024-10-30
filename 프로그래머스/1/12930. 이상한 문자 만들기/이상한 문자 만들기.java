class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;
        
        // 문자열을 하나씩 순회
        for(char c : s.toCharArray()){
            // 문자가 공백일 경우 그대로 붙이기
            if(Character.isSpaceChar(c)){
                sb.append(c);
                isUpper = true;
            } else {
                // 처음 등장하는 문자는 대문자
                if(isUpper){
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            }
        }
        
        
        // 문자열을 반환
        return sb.toString();
    }
}