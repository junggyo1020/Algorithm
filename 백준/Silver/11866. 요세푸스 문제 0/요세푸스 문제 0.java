import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            if (cnt == k) {
                list.add(q.poll());
                cnt = 0;
            } else {
                q.offer(q.poll());
            }
        }
        System.out.print("<");
        System.out.print(list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println(">");
    }
}