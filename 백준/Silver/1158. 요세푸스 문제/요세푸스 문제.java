import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        System.out.print("<");
        boolean flag = false;
        for (int x : answer) {
            if (!flag) {
                System.out.print(x);
                flag = true;
            } else {
                System.out.print(", " + x);
            }
        }
        System.out.print(">");
    }
}