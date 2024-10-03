import java.util.Scanner;

public class Main {

    static int t, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            int ret = 0;

            while (n >= 5) {
                ret += n / 5;
                n /= 5;
            }

            System.out.println(ret);
        }
    }
}
