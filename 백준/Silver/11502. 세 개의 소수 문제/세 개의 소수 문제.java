import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static final int MAX = 1000;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;

    private static void sieve() {
        isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i <= MAX; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sieve();
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            primes = new ArrayList<>();
            boolean flag = false;

            primes.add(3); // 골드바흐의 추측 이용하기 (2이상의 짝수는 2개의 소수로 무조건 표현 가능)
            N-=3; //N에 가장 작은 홀수 소수인 3을 빼줌으로써 N을 2보다 큰 짝수로 만든다.

            for(int p1 = 2; p1 <= N/2; p1++) {
                int p2 = N-p1;
                if(isPrime[p1] && isPrime[p2]) {
                    primes.add(p1);
                    primes.add(p2);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                sb.append("0").append("\n");
            } else {
                Collections.sort(primes);
                for(int x : primes) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
