import java.util.*;

class Solution {
    
    static HashMap<Integer, Long> hM;
    static double[] pSum;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        //우박 수열 구하기
        hM = new HashMap<>();
        int idx = 0;
        long cur = k;
        while(cur != 1) {
            hM.put(idx++, cur);
            if(cur % 2 == 0) cur /= 2;
            else cur = cur * 3 + 1;
        }
        hM.put(idx, 1L);
        
        //각 구간별 정적분 넓이 구하기
        pSum = new double[hM.size()];
        for(int i = 1; i < hM.size(); i++) {
            pSum[i] = pSum[i-1] + (hM.get(i-1) + hM.get(i)) / 2.0;
        }
        
        for(int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = hM.size() + ranges[i][1] - 1;
            
            if(a > b) {
                answer[i] = -1.0;
                continue;
            }
            
            answer[i] = pSum[b] - pSum[a];
        }
        
        return answer;
    }
}