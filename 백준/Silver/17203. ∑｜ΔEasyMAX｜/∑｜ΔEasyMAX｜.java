import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        int[] sums = new int[n];
        int[] psums = new int[n+1];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            sums[i] = Math.abs(nums[i] - nums[i - 1]);
        }
        for (int i = 0; i < n; i++) {
            psums[i+1] = psums[i] + sums[i];
        }

        for (int i = 0; i < q; i++) {
            int lt = sc.nextInt();
            int rt = sc.nextInt();
            int result = psums[rt] - psums[lt];
            System.out.println(result);
        }
    }
}