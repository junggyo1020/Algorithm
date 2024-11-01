class Solution {
    
    private boolean isValid(int[] citations, int h){
        // h 조건 검사
        int count = 0;
        for(int citation : citations){
            if(citation >= h){
                count++;
            }
        }
        
        return count >= h;
    }
    
    public int solution(int[] citations) {
        for(int h = citations.length; h >= 1; h--){
            //로직 추가
            if(isValid(citations, h)) return h;
        }    
        return 0;
    }
}