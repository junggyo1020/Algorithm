import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = arr[i][j];
                for (int k = 1; i + k < n && j + k < m; k++) {
                    if(arr[i+k][j] == tmp && arr[i][j+k] == tmp && arr[i+k][j+k] == tmp){
                        answer = Math.max(answer, (k+1)*(k+1));
                    } // 같지않으므로 건너뜀}
                }
            }
        }
        System.out.println(answer);
    }
}