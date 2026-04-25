import java.util.*;

class Solution {
    
    static List<Integer> list;
    static int answer, n, result;
    
    private static boolean calculate(List<Integer> op, int[] numbers) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(op.get(i) == 1) sum += numbers[i];
            else sum -= numbers[i];
        }
        
        return sum == result;
    }
    
    private static void dfs(int depth, List<Integer> op, int[] numbers) {
        //종료조건을 먼저 정의합시다
        if(depth == n) {
            //계산을 해보겠습니다.
            if(calculate(op, numbers)) answer++;
            return;
        }
        
        op.add(1);
        dfs(depth + 1, op, numbers);
        op.remove(op.size() - 1);
        op.add(0);
        dfs(depth + 1, op, numbers);
        op.remove(op.size() - 1);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0; //타겟 넘버를 만드는 방법의 수
        
        //먼저, 주어지는 숫자의 개수를 저장하는 변수를 선언합시다.
        n = numbers.length;
        result = target;
        
        //이제부터 부호를 저장할 리스트를 선언합니다.
        list = new ArrayList<>();
        
        //우리는 target의 숫자를 맞추기 위해, n개의 부호 조합을 맞춰볼겁니다.
        //초기값을 설정해야합니다.
        dfs(0, list, numbers);
        
        return answer;
    }
}