import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] top = new int[N/2];
        int[] bottom = new int[N/2];
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            if(i%2==0) bottom[i/2] = h;
            else top[i/2] = h;
        }
        Arrays.sort(bottom);
        Arrays.sort(top);

        int minCnt = Integer.MAX_VALUE;
        int cnt = 0;
        for (int height = 1; height <= H; height++) {
            int bCnt = bottom.length - findCnt(bottom, height);
            int tCnt = top.length - findCnt(top, H -height + 1);
            int totalCnt = bCnt + tCnt;

            if (totalCnt < minCnt) {
                minCnt = totalCnt;
                cnt = 1;
            }
            else if (totalCnt == minCnt) {
                cnt++;
            }
        }
        System.out.println(minCnt + " " + cnt);
    }

    private static int findCnt(int[] arr, int target) {
        int lt = 0, rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] >= target) rt = mid;
            else lt = mid + 1;
        }
        return lt;
    }
}