import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static long answer = Long.MAX_VALUE;
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = N-1;
        while(lt < rt) {
            long sum = (long)numbers[lt] + numbers[rt]; //형변환 항상 유의하자!
            if(Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                a = numbers[lt];
                b = numbers[rt];
            }
            if(sum == 0) {
                break;
            } else if(sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }


        System.out.println(a + " " + b);
    }
}
