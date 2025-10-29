import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String X, Y;
    static int minLen = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = st.nextToken();
        Y = st.nextToken();

        //슬라이딩 윈도우
        int xLen = X.length();
        int yLen = Y.length();
        for(int i = 0; i <= yLen - xLen; i++) {
            int diff = 0;
            for(int j = 0; j < xLen; j++) {
                if(X.charAt(j) != Y.charAt(i+j)) diff++;
            }
            minLen = Math.min(minLen, diff);
        }

        System.out.println(minLen);
    }
}
