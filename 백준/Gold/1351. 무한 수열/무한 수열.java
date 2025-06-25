import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    static long N, P, Q;
    static HashMap<Long, Long> hM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        hM = new HashMap<>();

        System.out.println(dp(N));
    }

    private static long dp(long n) {
        if(n == 0) return 1;
        if(hM.containsKey(n)) return hM.get(n);
        long val = dp(n / P) + dp(n / Q);
        hM.put(n, val);
        return val;
    }
}