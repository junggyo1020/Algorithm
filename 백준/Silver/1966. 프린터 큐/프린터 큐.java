import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int T;

    static class Node {
        int idx, val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Node> q = new ArrayDeque<>();
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                q.offer(new Node(i, tmp));
                pQ.offer(tmp);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (!pQ.isEmpty() && node.val == pQ.peek()) {
                    cnt++;
                    pQ.poll();
                    if (node.idx == M) {
                        answer.append(cnt).append('\n');
                        break;
                    }
                } else {
                    q.offer(node);
                }
            }
        }
        System.out.println(answer);
    }
}

