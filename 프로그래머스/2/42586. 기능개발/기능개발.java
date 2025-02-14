import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //5 10 1 1 20 1
        //1 3 2
        //즉, 처음에 progresses와 속도를 이용해, 완료되는 일 수를 구해 배열에 담는다.
        //Q. 단순히 나눗셈으로는 정확한 기간을 계산하기 어려움. 다른 방법이 있는지?
        //A. 만약 나누었는데 나머지가 존재하면 +1 해주기!
        int[] time = new int[progresses.length];
        for(int i = 0; i < time.length; i++){
            time[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) time[i]++;
        }
        //디버깅
        // for(int x : time) System.out.print(x + " ");
        
        //완료되는 일 수를 순회하여, 다음 인덱스의 값이 클거나, 마지막 인덱스에 도달할 때 까지 배열에 넣을 값을 누적한다.
        ArrayList<Integer> list = new ArrayList<>();
        int preNum = time[0];
        int cnt = 1;
        for(int i = 1; i < time.length; i++){
            //만약 다음 인덱스의 배열 값이 더 클경우 누적하는 값을 초기화 하고, 리스트에 추가한다.
            if(preNum < time[i]){
                list.add(cnt);
                cnt = 1;
                preNum = time[i];
            } else {
                cnt++;
            }
        }
        //마지막 인덱스까지 누적된 값도 추가해줘야한다.
        list.add(cnt);
        
        //이렇게 추가된 리스트의 값들을 배열로 변환해 반환한다.
        return list.stream().mapToInt(i -> i).toArray();
    }
}