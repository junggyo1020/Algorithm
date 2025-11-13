import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[] isPrime;
    static final int MAX = 100_000;

    private static void sieve() {
        isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; (long) i*i <= MAX; i++) {
            for(long j = (long)i*i; j <= MAX; j+=i) {
                isPrime[(int)j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        sieve();
        while (!(str = br.readLine()).equals("0")) {
            int N = str.length();
            int answer = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                int number=0;
                for(int j = i; j < N; j++) {
                    number = number * 10 + (str.charAt(j) - '0');

                    if(number > MAX) break;
                    if(isPrime[number]) {
                        answer = Math.max(answer, number);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
