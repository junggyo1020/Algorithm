import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tM = new TreeMap<>();
        
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if(op == 'I') {
                tM.merge(num, 1, Integer::sum);
            } else if(!tM.isEmpty()) {
                if(num == 1) {
                    int maxKey = tM.lastKey();
                    if(tM.get(maxKey) == 1) tM.remove(maxKey);
                    else tM.merge(tM.lastKey(), -1, Integer::sum);
                } else {
                    int minKey = tM.firstKey();
                    if(tM.get(minKey) == 1) tM.remove(minKey);
                    else tM.merge(tM.firstKey(), -1, Integer::sum);
                }
            } 
        }
        
        if(tM.isEmpty()) return new int[]{0, 0};
        return new int[]{tM.lastKey(), tM.firstKey()};
    }
}