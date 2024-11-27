class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        for(char c : s.toCharArray()){
            sb.append(c);
        }
        s = sb.reverse().toString();
        
        int[] arr = new int[s.length()];
        
        int index = 0;
        for(char c : s.toCharArray()){
            arr[index] = c - '0';
            index++;
        }
        
        return arr;
    }
}