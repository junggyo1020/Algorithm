import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int range = n / k;

        for (int i = 0; i < n; i += range) {
            Arrays.sort(arr, i , i + range);
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}