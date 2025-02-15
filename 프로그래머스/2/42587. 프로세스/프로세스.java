import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        //중요도와 인덱스를 모두 저장
        for(int i = 0; i < priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }
        
        int answer = 0;
        
        while(!q.isEmpty()){
            int[] current = q.poll(); //인덱스, 중요도
            
            //중요도가 가장 높은 경우
            if(current[1] == pq.peek()) {
                pq.poll(); //우선순위 큐에서도 제거
                answer++;
                //내가 찾는 인덱스가 같으면 그대로 반환
                if(current[0] == location) return answer;
            } else {
                //중요도가 가장 높지 않으면 다시 큐에 넣기
                q.offer(current);
            }
        }
        return answer;
    }
}