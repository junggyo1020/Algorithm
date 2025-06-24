import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int M, x;
    static boolean[] S;
    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        S = new boolean[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S[x] = true;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S[x] = false;
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(S[x] ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S[x] = !S[x];
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        S[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        S[j] = false;
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}