import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        //1. 작업 읽기
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(op == 'I') {
                maxPQ.offer(num);
                minPQ.offer(num);
            }
            else if(!maxPQ.isEmpty() && !minPQ.isEmpty()){
                if(num == 1) {
                    int maxVal = maxPQ.poll();
                    minPQ.remove(maxVal);
                }
                else if(num == -1) {
                    int minVal = minPQ.poll();
                    maxPQ.remove(minVal);
                }
            }
        }
        
        if(maxPQ.isEmpty()) return new int[]{0, 0};
        return new int[]{maxPQ.poll(), minPQ.poll()};
    }
}