import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long cmd = Long.parseLong(br.readLine());
            if (cmd == 0) {
                if (pQ.isEmpty()) {
                    answer.append(0).append('\n');
                } else {
                    answer.append(pQ.poll()).append('\n');
                }
            } else {
                pQ.offer(cmd);
            }
        }
        System.out.println(answer);
    }
}