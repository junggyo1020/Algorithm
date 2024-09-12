import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            //빈칸 채우기
            for (int j = 1; j <= n - i; j++) {
                bw.write(" ");
            }
            //별 그리기
            for (int j = 1; j <= 2 * i - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        for (int i = n-1; i >= 1; i--) {
            //빈칸 채우기
            for (int j = 1; j <= n - i; j++) {
                bw.write(" ");
            }
            //별 그리기
            for (int j = 1; j <= 2 * i - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}