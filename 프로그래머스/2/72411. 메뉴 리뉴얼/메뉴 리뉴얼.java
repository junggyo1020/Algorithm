import java.util.*;
import java.util.Map.*;

class Solution {
    
    static Map<Integer, Map<String, Integer>> eM;
    static char[] results;
    static int N, M;
    static List<String> answer;
    
    public String[] solution(String[] orders, int[] course) {
        eM = new HashMap<>();
        answer = new ArrayList<>();
        
        for(String order : orders) {
            N = order.length();
            for(int i = 0; i < course.length; i++) {
                M = course[i];
                results = new char[M];
                //N개 중 M개 뽑는 조합 찾기
                dfs(0, 0, order);
            }
        }
        
        //길이별 최대값 구하기
        for(Map<String, Integer> iM : eM.values()) {
            int maxNum = -1;
            for(Entry<String, Integer> x : iM.entrySet()) {
                if(x.getValue() > 1 && x.getValue() > maxNum) {
                    maxNum = x.getValue();
                }
            }
            
            
            for(Entry<String, Integer> x2 : iM.entrySet()) {
                if(x2.getValue() == maxNum) {
                    answer.add(x2.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private static void dfs(int cnt, int start, String order) {
        if(cnt == M) { //M개 다 뽑았다면?
            StringBuilder sb = new StringBuilder();
            char[] copyOfResults = results.clone();
            Arrays.sort(copyOfResults);
            for(char x : copyOfResults) {
                sb.append(x);
            }
            String s = sb.toString();
            
            //innerMap에 s 넣기
            eM.computeIfAbsent(M, k -> new HashMap<>())
                .merge(s, 1, Integer::sum);
            return;
        }
        
        for(int i = start; i < N; i++) {
            results[cnt] = order.charAt(i);
            dfs(cnt + 1, i + 1, order);
        }
    }
}