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
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        //소수 담기
        primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sieve();

        int s = 0, e = 0, sum = 0, count = 0;
        int size = primes.size();
        while(true) {
            if(sum >= N) {
                if(sum == N) count++;
                sum -= primes.get(s++);
            } else if(e == size) {
                break;
            } else {
                sum += primes.get(e++);
            }
        }

        System.out.println(count);
    }
}
