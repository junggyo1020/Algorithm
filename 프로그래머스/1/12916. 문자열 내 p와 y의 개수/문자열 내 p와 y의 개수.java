class Solution {
    boolean solution(String s) {
        int p_count = 0, y_count = 0;
        s = s.toUpperCase();
        for(char ch : s.toCharArray()){
            if(ch == 'P'){
                p_count++;
            } else if(ch == 'Y'){
                y_count++;
            }
        }
        return (p_count == y_count);
    }
}