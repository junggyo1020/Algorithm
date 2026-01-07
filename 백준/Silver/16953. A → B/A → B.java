import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int A, B;
    static long answer = -1;

    static class Node {
        long num, time;
        Node(long num, long time) {
            this.num = num;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(A, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.num == B) {
                System.out.println(cur.time + 1);
                return;
            }

            if(cur.num * 2 <= B) {
                q.offer(new Node(cur.num * 2, cur.time + 1));
            }
            if(cur.num * 10 + 1 <= B) {
                q.offer(new Node(cur.num * 10 + 1, cur.time + 1));
            }
        }

        System.out.println(answer);
    }
}