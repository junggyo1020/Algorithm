import java.util.Scanner;

class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i; //최악의 경우 1^2을 i번 사용함
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i-j*j] + 1);
            }
        }

        System.out.println(arr[n]);
    }
}