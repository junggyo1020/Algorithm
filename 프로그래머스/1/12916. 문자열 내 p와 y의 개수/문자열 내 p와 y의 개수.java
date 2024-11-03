class Solution {
    boolean solution(String s) {
        int p_count = 0;
        int y_count = 0;
        s = s.toUpperCase();
        for(char c : s.toCharArray()){
            if(c == 'P') p_count++;
            if(c == 'Y') y_count++;
        }
        if(p_count == y_count) return true;
        return false;
    }
}