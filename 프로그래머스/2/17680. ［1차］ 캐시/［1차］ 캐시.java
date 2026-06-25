import java.util.*;

class Solution {
    
    static ArrayDeque<String> dq;
    static HashSet<String> hs;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        //LRU 구현
        //캐시 -> 큐
        dq = new ArrayDeque<>();
        hs = new HashSet<>();
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(String city : cities) {
            String LowerCity = city.toLowerCase();
            //cache hit
            if(hs.contains(LowerCity)) {
                dq.remove(LowerCity);
                dq.offer(LowerCity);
                answer += 1;
            }
            //cache miss
            else if(dq.size() < cacheSize) {
                dq.offer(LowerCity);
                hs.add(LowerCity);
                answer += 5;
            }
            else {
                hs.remove(dq.poll());
                dq.offer(LowerCity);
                hs.add(LowerCity);
                answer += 5;
            }
        }
        
        return answer;
    }
}