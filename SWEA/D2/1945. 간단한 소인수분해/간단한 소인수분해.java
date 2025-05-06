import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    static final int[] arr = {2, 3, 5, 7, 11};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            List<Integer> answer = new ArrayList<>();
            int num = sc.nextInt();
            for (int x : arr) {
                int cnt = 0;
                while (num % x == 0) {
                    num /= x;
                    cnt++;
                }
                answer.add(cnt);
            }
            System.out.print("#" + t + " ");
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}