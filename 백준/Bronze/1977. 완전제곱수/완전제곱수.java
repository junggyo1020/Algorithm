import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int sum, minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        boolean flag = false;

        for(int i = M; i <= N; i++) {
            if(check(i)) {
                flag = true;
                sum += i;
                minValue = Math.min(minValue, i);
            }
        }

        if(flag) {
            System.out.println(sum);
            System.out.println(minValue);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean check(int num) {
        double sqrtNum = Math.sqrt(num);
        return sqrtNum == (int)sqrtNum;
    }
}
