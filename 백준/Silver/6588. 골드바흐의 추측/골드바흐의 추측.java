import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sieve();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean found = false;
            for (int a = 3; a <= n / 2; a += 2) {
                if (isPrime[a] && isPrime[n - a]) {
                    System.out.println(n + " = " + a + " + " + (n - a));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    static void sieve() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
