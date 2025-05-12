import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        //배열에 값 저장
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0'; //정수형으로 변경
            }
        }

        StringBuilder sb = new StringBuilder();
        compress(arr, 0, 0, n, sb);
        System.out.println(sb);
    }

    private static void compress(int[][] arr, int y, int x, int size, StringBuilder sb) {
        //구성이 모두 같은 단어인지 확인
        if (isSame(arr, y, x, size)) {
            sb.append(arr[y][x]);
        } else {
            // divide
            int newSize = size / 2;

            sb.append("(");
            compress(arr, y, x, newSize, sb);
            compress(arr, y, x + newSize, newSize, sb);
            compress(arr, y + newSize, x, newSize, sb);
            compress(arr, y + newSize, x + newSize, newSize, sb);
            sb.append(")");
        }
    }
    private static boolean isSame(int[][] arr, int y, int x, int size) {
        int first = arr[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(arr[i][j] != first) return false;
            }
        }
        return true;
    }
}