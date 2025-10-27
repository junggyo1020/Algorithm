import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int T, n;
    static String p, str;
    static StringBuilder sb = new StringBuilder();
    static boolean isReversed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        //테스트케이스 시작
        for(int t = 1; t <= T; t++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            isReversed = false;

            //문자열 -> 배열
            String[] strs = str.substring(1, str.length() - 1).split(",");

            Deque<Integer> deq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deq.add(Integer.parseInt(strs[i]));
            }

            //커맨드 수행
            char[] op = p.toCharArray();

            int cnt = 0;
            for(char x : op) {
                if(x == 'D') cnt++;
            }

            if(cnt > deq.size()) {
                sb.append("error").append("\n");
                continue;
            }

            for (int i = 0; i < op.length; i++) {
                char x = op[i];
                //뒤집기
                if(x == 'R') {
                    isReversed = !isReversed;
                }
                //버리기
                if(x == 'D') {
                    if(!isReversed) deq.pollFirst();
                    else deq.pollLast();
                }
            }

            sb.append("[");
            while(!deq.isEmpty()) {
                if(!isReversed) sb.append(deq.pollFirst());
                else sb.append(deq.pollLast());

                if(!deq.isEmpty()) sb.append(",");
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}
