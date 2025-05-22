import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();

            Arrays.sort(a);
            Arrays.sort(b);

            int e = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                while(e < m && a[i] > b[e]) e++;
                cnt += e;
            }
            System.out.println(cnt + " ");
        }
    }
}