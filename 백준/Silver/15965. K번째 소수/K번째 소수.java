import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = 8000000;
        boolean[] isPrime = new boolean[n+1];
        int count = 0;

        for(int i = 2; i <= n; i++){
            if (!isPrime[i]) {
                count++;
                if (count == k) {
                    System.out.println(i);
                    return;
                }
                for (long j = (long)i * i; j <= n; j += i) {
                    isPrime[(int)j] = true;
                }
            }
        }
    }
}