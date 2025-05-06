import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int[] arr = new int[L];
        for (int i = 0; i < L; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Arrays.sort(arr);
        for (int x : arr) {
            if (x == n) {
                System.out.println(0);
                return;
            }
        }

        int left = 0;
        int right = 1001;
        for (int x : arr) {
            if(x < n) left = x;
            else if(x > n){
                right = x;
                break;
            }
        }

        int result = (n - left) * (right - n) - 1;
        System.out.println(result);
    }
}