import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Main {

    static int N;
    static Map<Long, Integer> hM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hM = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            hM.put(num, hM.getOrDefault(num, 0) + 1);
        }
        int mCnt = -1;
        long mVal = Long.MIN_VALUE;
        for (Entry<Long, Integer> x : hM.entrySet()) {
            if (x.getValue() > mCnt) {
                mVal = x.getKey();
                mCnt = x.getValue();
            } else if (x.getValue() == mCnt) {
                mVal = Math.min(mVal, x.getKey());
            }
        }
        System.out.println(mVal);
    }
}