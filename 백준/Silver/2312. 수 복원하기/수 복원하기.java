import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    static int N;
    static boolean[] isDecimal;
    static final int MAX = 100_004;
    private static void sieve() {
        isDecimal = new boolean[MAX+1];
        Arrays.fill(isDecimal, true);
        isDecimal[0] = isDecimal[1] = false;

        for(int i = 2; i*i <= MAX; i++) {
            if(isDecimal[i]) {
                for(long j = i*i; j <= MAX; j+=i) {
                    isDecimal[(int)j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sieve(); //소수 배열 저장

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            int num = N;
            Map<Integer, Integer> hm = new LinkedHashMap<>();
            for(int i = 2; i <= N; i++) {
                if(isDecimal[i]) {
                    while(num % i == 0) {
                        num /= i;
                        hm.put(i, hm.getOrDefault(i, 0) + 1);
                    }
                }
            }

            for(Map.Entry node : hm.entrySet()) {
                sb.append(node.getKey()).append(" ").append(node.getValue()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
