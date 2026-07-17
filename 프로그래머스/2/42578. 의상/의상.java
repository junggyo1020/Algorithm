import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hM = new HashMap<>();
        for(String[] cloth : clothes) {
            hM.merge(cloth[1], 1, Integer::sum);
        }
        
        int result = 1;
        for(int x : hM.values()) {
            result *= (x+1);
        }
        
        return result - 1;
    }
}