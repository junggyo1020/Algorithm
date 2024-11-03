class Solution {
    
    private int countZeros(String s){
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zeros++;
        }
        return zeros;
    }
    
    public int[] solution(String s) {
        int zero = 0;
        int loop = 0;
        while(!s.equals("1")){
            int zeros = countZeros(s);
            loop += 1;
            zero += zeros;
            
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }
        return new int[] {loop, zero};
    }
}