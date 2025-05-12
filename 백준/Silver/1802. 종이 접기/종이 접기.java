import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.charAt(i) - '0';
            }

            System.out.println(canFold(arr, 0, n-1) ? "YES" : "NO");
        }
    }

    private static boolean canFold (int[] arr, int left, int right) {
        int len = right - left + 1;
        int mid = (left + right) / 2;

        if(len == 1) return true;

        for (int i = 0; i < len / 2; i++) {
            if(arr[left + i] == arr[right - i]) return false;
        }

        return canFold(arr, left, mid - 1) && canFold(arr, mid + 1, right);
    }
}