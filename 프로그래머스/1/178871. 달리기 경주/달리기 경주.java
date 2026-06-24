import java.util.*;
import java.util.Map.*;

class Solution {
    
    static Map<String, Integer> nameToScore;
    static Map<Integer, String> scoreToName;
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        nameToScore = new HashMap<>();
        scoreToName = new TreeMap<>();
        
        int idx = 0;
        for(String player : players) {
            nameToScore.put(player, idx);
            scoreToName.put(idx, player);
            idx++;
        }
        
        for(String calling : callings) {
            int score = nameToScore.get(calling);
            //앞사람 이름
            String prevName = scoreToName.get(score - 1);
            
            //내 순위 증가
            nameToScore.put(calling, score - 1);
            scoreToName.put(score-1, calling);
            
            //앞 사람 순위 감소
            nameToScore.put(prevName, score);
            scoreToName.put(score, prevName);
        }
        
        int index = 0;
        for(String name : scoreToName.values()) {
            answer[index++] = name;
        }
        
        return answer;
    }
}