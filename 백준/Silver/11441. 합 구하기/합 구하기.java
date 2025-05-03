import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] pSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pSum[i+1] = pSum[i] + arr[i];
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int lt = sc.nextInt();
            int rt = sc.nextInt();
            int result = pSum[rt] - pSum[lt-1];
            System.out.println(result);
        }
    }
}