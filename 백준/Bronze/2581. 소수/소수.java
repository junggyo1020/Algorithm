import java.io.*;
import java.util.Arrays;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        //소수 찾기
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        boolean flag = true;
        int min = 0;
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                if(flag){
                    flag = false;;
                    min = i;
                }
                sum += i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}