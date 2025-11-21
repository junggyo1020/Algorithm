import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C;

    private static long pow (int a, int b) {
//        System.out.println("pow("+a+", "+ b + ")");;
        if(b == 1) return a % C; // 1

        long half = pow(a, b / 2); // 2

        if(b % 2 == 0) return (half * half) % C; // 3
        else return ((half * half % C) * a) % C; // 4
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }
}
