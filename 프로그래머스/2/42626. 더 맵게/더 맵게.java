/**
    모든 음식의 스코빌 지수 K 이상으로
    - 우선 스코빌 지수 순으로 오름차순 정렬되어야 함.
    - 매번 섞은 음식을 포함하여 정렬되어야 하므로 힙 사용해야 함.
    
    1. scoville 배열을 힙에 넣는다.
    2. 모든 음식의 스코빌 지수가 K이상인지 확인한다. (큐의 가장 끝에 있는 값이 K이상이면 됨)
    3. O이면 answer값 반환
    4. X이면 두개를 빼서 섞고, 하나를 큐에 넣은 다음 answer++
**/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0; //섞은 횟수
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //1
        for(int x : scoville) {
            pq.offer(x);
        }
        
        //3
        while(pq.size() >= 2) {
            //2
            int val = pq.poll(); //큐에서 가장 작은 값
        
            //3
            if(val >= K) return answer;
        
            //4
            else {
                int val2 = pq.poll();
                pq.offer(val + (val2 * 2));
                answer++;
            }
        }
        
        return pq.peek() >= K ? answer : -1;
    }
}