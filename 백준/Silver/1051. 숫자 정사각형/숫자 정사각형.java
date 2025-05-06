import java.util.Scanner;

class Main {
    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = arr[i][j];
                boolean flag = false;
                for (int k = 1; k < 50; k++) {
                    int ny = i + k;
                    int nx = j + k;
                    if(ny >= n || nx >= m) break;
                    if(arr[ny][j] == tmp && arr[i][nx] == tmp && arr[ny][nx] == tmp){
                        answer = Math.max(answer, (k+1)*(k+1));
                    } // 같지않으므로 건너뜀}
                }
            }
        }
        System.out.println(answer);
    }
}