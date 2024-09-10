import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String[] test = br.readLine().split(" ");
            int a = Integer.parseInt(test[0]);
            int b = Integer.parseInt(test[1]);

            System.out.format("Case #%d: %d + %d = %d\n", i, a, b, a + b);
        }
    }
}