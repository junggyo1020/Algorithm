import java.util.*;

class Solution {
    
    static PriorityQueue<Node> initpq, pq;
    static int time, result;
    
    static class Node implements Comparable<Node> {
        int ot, st, on;
        
        Node(int ot, int st, int on) {
            this.ot = ot;
            this.st = st;
            this.on = on;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.ot == o.ot) {
                if(this.st == o.st) return Integer.compare(this.on, o.on);
                return Integer.compare(this.st, o.st);
            }
            return Integer.compare(this.ot, o.ot);
        }
    }
    
    public int solution(int[][] jobs) {
        initpq = new PriorityQueue<>();
        time = 0; result = 0;
        pq = new PriorityQueue<>((a, b) -> {
            if(a.st != b.st) return Integer.compare(a.st, b.st);
            if(a.ot != b.ot) return Integer.compare(a.ot, b.ot);
            return Integer.compare(a.on, b.on);
        });
        
        int size = jobs.length;
        for(int i = 0; i < size; i++) {
            int s = jobs[i][0];
            int l = jobs[i][1];
            initpq.offer(new Node(s, l, i));
        }
        
        while(!initpq.isEmpty() || !pq.isEmpty()) {
            //1. 요청시간 <= time인 것들을 모두 우선순위 큐에 담음
            while(!initpq.isEmpty() && initpq.peek().ot <= time) {
                pq.offer(initpq.poll());
            }
            
            if(pq.isEmpty()) {
                time = initpq.peek().ot;
                continue;
            }

            //2. 우선순위 큐에서 하나 poll
            Node cur = pq.poll();
            // 3. time += l
            time += cur.st;
            // 4. result += (time - s)
            result += (time - cur.ot);
            // 5. 초기 큐가 빌 때까지 1번 과정 반복
        }
        
        return result / size;
    }
}
/**
[[0,3], [1,9], [3,5]]

작업들을 정렬해야함 -> 작업 요청시간(오름차순), 소요시간(오름차순), 작업번호(오름차순) -> 객체로 담아 큐로 저장

관리할 시간 필요 -> time 변수 선언 = 0으로 초기화

디스크 컨트롤러는 우선순위 큐로 관리 -> 작업 소요시간(오름차순), 요청시간(오름차순), 작업번호(작은순)
작업의 반환시간을 저장하는 변수 = result = 0

1. 요청시간 <= time인 것들을 모두 우선순위 큐에 담음
2. 우선순위 큐에서 하나 poll
3. time += l
4. result += (time - s)
5. 초기 큐가 빌 때까지 1번 과정 반복
6. result / size 값을 return

반환시간 = 작업 종료 시각 - 요청 시각
- 요청시각 = s, 작업종료시각 = time

**/