import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long prefixSum = 0;
        long answer = 0;
        for(int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());
            answer += num * prefixSum;
            prefixSum += num;
        }

        System.out.println(answer);
    }

}
