import java.util.*;

class Solution {
    
    static int minResult;
    
    private static boolean isValid(String cur, String target) {
        int cnt = 0;
        int len = cur.length();
        
        for(int i = 0; i < len; i++) {
            if(cur.charAt(i) != target.charAt(i)) cnt++;
        }
        
        return cnt == 1;
    }
    
    private static void dfs(String cur, String target, 
                            int depth, String[] words, HashSet<String> hs) {
    
        if(depth > minResult) return;
        
        if(cur.equals(target)) {
            minResult = Math.min(minResult, depth);
            return;
        }
        
        for(String next : words) {
            if(isValid(cur, next) && !hs.contains(next)) {
                hs.add(next);
                dfs(next, target, depth + 1, words, hs);
                hs.remove(next);
            }
        }
        
        
    }
    
    public int solution(String begin, String target, String[] words) {
        HashSet<String> hs = new HashSet<>();
        minResult = Integer.MAX_VALUE;
        dfs(begin, target, 0, words, hs);
        
        return minResult == Integer.MAX_VALUE ? 0 : minResult;
    }
}