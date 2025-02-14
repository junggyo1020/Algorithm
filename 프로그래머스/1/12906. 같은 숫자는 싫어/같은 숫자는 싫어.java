import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = -1;
        for(int x : arr){
            if(x != num){
                list.add(x);
                num = x;
            }
        }
        
        int idx = 0;
        int[] answer = new int[list.size()];
        for(int x : list){
            answer[idx++] = x;
        }
        
        return answer;
    }
}