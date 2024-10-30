class Solution {
    
    private int countZeros(String s){
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeros++;
            }
        }
        return zeros;
    }
    
    public int[] solution(String s) {
        int loop = 0; // 반복 횟수
        int removed = 0; // 제거할 0의 개수
        // 문자열 s가 "1"이 될 때까지 반복한다.
        while(!s.equals("1")){
            // 문자열 s의 모든 0을 제거한다.
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;
            
            // 문자열 s의 길이 c를 2진법으로 표현한 문자열로 변환
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }
        // 변환된 횟수와 제거된 모든 0의 개수를 배열에 담아 반환한다.
        return new int[] {loop, removed};
    }
}