import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int K, N;
    static long maxValue = Long.MIN_VALUE;
    static long[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        line = new long[K];
        for (int i = 0; i < K; i++) {
            line[i] = Long.parseLong(br.readLine());
            maxValue = Math.max(maxValue, line[i]);
        }
        long lt = 1;
        long rt = maxValue;
        long answer = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            if(mid == 0) mid = 1;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += line[i] / mid;
            }

            if (cnt >= N) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}