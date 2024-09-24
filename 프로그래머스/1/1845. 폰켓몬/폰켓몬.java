import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        int size = set.size();
        
        int maxSize = nums.length/2;
        
        answer = Math.min(size, maxSize);
        
        return answer;
    }
}