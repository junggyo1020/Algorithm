class Solution {
    
    private char push(char c, int n){
        if(!Character.isAlphabetic(c)) return c;
        
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        
        position = (position + n) % ('Z' - 'A' + 1); // 0부터 'Z'-'A' 까지 표현가능
        
        return (char)(offset + position);
    }
    
    public String solution(String s, int n) {
        //알파벳 각각을 담은 배열 만들기
        char[] alpha = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : alpha){
            str.append(push(c, n));
        }
        return str.toString();
    }
}