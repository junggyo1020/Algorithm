/**
숫자를 하나씩 넣는다.
44 1
1 1
31 1
25 1

0인 경우는 알아볼 수 없는 번호 개수 추가 -> blindCnt

당첨 번호를 순회하며 이미 해시셋에 존재하는 숫자 개수를 찾는다. -> correctCnt

최대 순위와 최저 순위를 구한다.
최저 순위 = 7 - correctCnt
최대 순위 = 7 - (correctCnt + blindCnt)
**/
import java.util.*;
class Solution {
    
    static HashSet<Integer> hs;
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        hs = new HashSet<>();
        int blindCnt = 0;
        for(int x : lottos) {
            if(x == 0) {
                blindCnt++;
                continue;
            }
            hs.add(x);
        }
        
        int correctCnt = 0;
        for(int x : win_nums) {
            if(hs.contains(x)) correctCnt++;
        }
        
        //최소 순위
        answer[1] = (correctCnt == 0) ? 6 : 7 - correctCnt;
    
        //최고 순위
        answer[0] = (blindCnt + correctCnt) < 1 ? 6 : 7 - (correctCnt + blindCnt); 
        
        return answer;
    }
}