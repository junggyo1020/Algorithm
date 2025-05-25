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

        Arrays.sort(arr);

        int lt = 0;
        int cLen = 0;
        int answer = Integer.MAX_VALUE;
        for (int rt = 0; rt < n; rt++) {
            while(arr[rt] - arr[lt] >= 5) lt++;
            cLen = rt - lt + 1;
            answer = Math.min(answer, 5 - cLen);
        }
        System.out.println(answer);
    }
}