import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 1299709;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 초기화: 에라토스테네스의 체
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if (isPrime[k]) {
                System.out.println(0);
                continue;
            }

            int lower = k;
            while (lower > 0 && !isPrime[lower]) lower--;

            int upper = k;
            while (upper <= MAX && !isPrime[upper]) upper++;

            System.out.println(upper - lower);
        }
    }
}
