import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1]; // 연산의 최소 횟수 저장
        int[] prev = new int[n+1]; // 이전에 방문한 숫자 기록

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i / 2;
            }
        }

        System.out.println(dp[n]);

        //걍로 저장하기
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = n; i > 0; i = prev[i]) {
            path.add(i);
        }

        for (int x : path) {
            System.out.print(x + " ");
        }
    }
}