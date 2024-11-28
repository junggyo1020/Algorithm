class Solution {
    
    private static int frequency;
    private static int zeroCnt;
    
    private void countZeros(String s){
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeroCnt++;
            }
        }
    }
    
    private String changeDigit(String s){
        s = s.replace("0", "");
        return Integer.toString(s.length(), 2);
    }
    
    public int[] solution(String s) {
        frequency = 0;
        zeroCnt = 0;
        
        while(!s.equals("1")){
            countZeros(s);
            frequency++;
            s = changeDigit(s);
        }
        return new int[]{frequency, zeroCnt};
    }
}