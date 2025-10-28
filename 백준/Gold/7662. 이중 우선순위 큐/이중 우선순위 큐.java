import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int K;
    static StringTokenizer st;
    static char op;
    static int n;
    static TreeMap<Integer, Integer> tm;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            tm = new TreeMap<>();
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                op = st.nextToken().charAt(0); //연산 종류
                n = Integer.parseInt(st.nextToken());

                //삽입
                if(op == 'I') {
                    tm.put(n, tm.getOrDefault(n, 0) + 1);
                }
                if(op == 'D') {
                    if(tm.isEmpty()) continue;
                    if(n == -1) {
                        if(tm.get(tm.firstKey()) == 1) tm.remove(tm.firstKey());
                        else tm.put(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                    }
                    if(n == 1) {
                        if(tm.get(tm.lastKey()) == 1) tm.remove(tm.lastKey());
                        else tm.put(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                    }
                }
            }
            if(tm.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

