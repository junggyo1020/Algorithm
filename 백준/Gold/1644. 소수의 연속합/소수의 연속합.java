import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static final int MAX = 4_000_000;
    static int N;
    static boolean[] isPrime;
    static ArrayList<Integer> primes;
    static Integer[] arr;

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

        //소수 담기
        primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }

        //리스트 -> 배열
        arr = primes.toArray(new Integer[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sieve();

        int s = 0, e = 0, sum = 0, count = 0;
        int size = arr.length;
        while(true) {
            if(sum >= N) {
                if(sum == N) count++;
                sum -= arr[s++];
            } else if(e == size) {
                break;
            } else {
                sum += arr[e++];
            }
        }

        System.out.println(count);
    }
}
