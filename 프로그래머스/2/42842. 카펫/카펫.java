class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int c = 3; c <= 5000; c++) {
            int r = (brown + yellow) / c;
            
            if((r-2) * (c-2) == yellow) {
                answer[0] = r;
                answer[1] = c;
                break;
            }
            
        }
        
        return answer;
    }
}