import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * P^k <= B인 소수를 범위에 따라 찾는 문제
 * P의 최대 탐색 범위를 찾자.
 * P^2 <= B(10^14)
 * P <= B(10^7)
 * P <= 10,000,000 (1천만)
 */
public class Main {

    static boolean[] isDecimal;
    static final int MAX = 10_000_004;

    private static void sieve() {
        isDecimal = new boolean[MAX+1];
        Arrays.fill(isDecimal, true);
        isDecimal[0] = isDecimal[1] = false;
        for(int i = 2; (long)i*i <= MAX; i++) {
            if(isDecimal[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isDecimal[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        sieve();

        long result = 0;
        for(long i = 2; i <= MAX; i++) {
            if(isDecimal[(int)i]) {
                long num = i;
                while (num <= b/i) { // num*i <= b까지 반복
                    num *= i;
                    if (num >= a) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
