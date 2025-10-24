import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N; //수식의 길이
    static String str; //수식
    static int[] numbers; //숫자
    static char[] operators; //연산자
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        //1. 숫자와 연산자 분리하기
        numbers = new int[N/2+1];
        operators = new char[N/2];
        int cnt = 0, cnt2 = 0;
        for(int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            if(i % 2 == 0) { //숫자
                numbers[cnt++] = ch - '0';
            } else { //연산자
                operators[cnt2++] = ch;
            }
        }

        //1-1. 디버깅
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(Arrays.toString(operators));

        //2. 만들 수 있는 모든 수식을 순회하기
        answer = Long.MIN_VALUE;
        dfs(0, (long)numbers[0]);
        System.out.println(answer);
    }

    private static void dfs(int pos, long sum) {
        //2-1. 모두 순회한 경우 식 계산
        if(pos >= N/2) {
            answer = Math.max(answer, sum);
            return;
        }

        //2-2. 괄호를 치지 않고 그냥 계산하기
        long result = calculate(sum, operators[pos], (long)numbers[pos+1]);
        dfs(pos+1, result);

        //2-3. 괄호를 추가하는 경우 => 다음 연산자를 미리 계산하기
        if(pos + 1 < N/2) {
            long nextSum = calculate((long) numbers[pos + 1], operators[pos + 1], (long) numbers[pos + 2]);
            long result2 = calculate(sum, operators[pos], nextSum);
            dfs(pos + 2, result2);
        }
    }

    private static long calculate(long num1, char op, long num2) {
        if(op == '+') return num1 + num2;
        else if(op == '-') return num1 - num2;
        else if(op == '*') return num1 * num2;
        return 0L;
    }
}
