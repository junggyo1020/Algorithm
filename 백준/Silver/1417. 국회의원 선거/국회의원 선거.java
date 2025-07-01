import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int target = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            pQ.offer(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while (!pQ.isEmpty() && target <= pQ.peek()) {
            int cur = pQ.poll();
            pQ.offer(cur - 1);
            target++;
            cnt++;
        }

        System.out.println(cnt);
    }
}