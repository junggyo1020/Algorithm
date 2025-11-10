import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;


    private static void sieve() {
        isPrime = new boolean[N+1];
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; (long)i*i <= N; i++) {
            if(isPrime[i]) {
                for(long j = (long)i*i; j <= N; j+=i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //1이상 N이하의 모든 자연수로 나누어 진다. => 1부터 N까지를 모두 약수로 가진다. => lcm 구하기
        sieve();
        long lcm = 1;
        long M = 987654321;

        for(int p : primes) {
            long power = p;
            while(power <= N/p) {
                power *= p;
            }

            lcm = (lcm * power) % M;
        }

        System.out.println(lcm);
    }
}
