import java.util.Scanner;

class Main {

    static int n;
    static long[] arr;

    private static long dp(int num) {

        if(num == 1 || num == 2) return 1;
        if(arr[num] != 0) return arr[num];
        return arr[num] = dp(num-1) + dp(num-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //n자리 이진수 개수 구해야 함.
        arr = new long[n+1]; //1-based index 이므로 n+1 크기로 지정

        System.out.println(dp(n));
    }
}