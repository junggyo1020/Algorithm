import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String str = sc.next();
            int n = str.length();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = str.charAt(i) - '0';
            }
            System.out.println(canFold(s, 0, n -1) ? "YES" : "NO");
        }
    }

    private static boolean canFold(int[] s, int left, int right) {
        int len = right - left + 1;
        int mid = (left + right) / 2;

        if(len == 1) return true;

        for (int i = 0; i < len / 2; i++) {
            if(s[left + i] == s[right - i]) return false;
        }

        return canFold(s, left, mid -1) && canFold(s, mid + 1, right);
    }
}