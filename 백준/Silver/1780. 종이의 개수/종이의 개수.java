import java.util.Scanner;

class Main {

    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        answer = new int[3];

        //배열 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        compress(arr, 0, 0, n);

        for (int x : answer) {
            System.out.println(x);
        }
    }

    private static void compress(int[][] arr, int y, int x, int size) {
        if (isSame(arr, y, x, size)) {
            answer[arr[y][x] + 1]++;
        } else {
            int newSize = size / 3;
            compress(arr, y, x, newSize);
            compress(arr, y, x + newSize, newSize);
            compress(arr, y, x + newSize * 2, newSize);
            compress(arr, y + newSize, x, newSize);
            compress(arr, y + newSize, x + newSize, newSize);
            compress(arr, y + newSize, x + newSize * 2, newSize);
            compress(arr, y + newSize * 2, x, newSize);
            compress(arr, y + newSize * 2, x + newSize, newSize);
            compress(arr, y + newSize * 2, x + newSize * 2, newSize);
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