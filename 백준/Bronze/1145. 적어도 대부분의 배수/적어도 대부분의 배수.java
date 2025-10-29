import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;
        while(true) {
            if(check(num)){
                System.out.println(num);
                System.exit(0);
            }
            num++;
        }
    }

    private static boolean check(int num) {
        int cnt = 0;
        for(int x : arr) {
            if(num % x == 0) cnt++;
        }
        return cnt >= 3;
    }
}
