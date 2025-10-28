import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1, s = 1, m = 1;
        int cnt = 1;

        while(true) {
            if(e == E && s == S && m == M) {
                System.out.println(cnt);
                break;
            }
            
            //각각의 범위를 도달하면 모듈러로 0으로 초기화한다.
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;

            cnt++;
        }
    }
}
