import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[104];
        for (int a = 0; a < m; a++) {
            String[] temp = br.readLine().split(" ");
            int i = Integer.parseInt(temp[0]);
            int j = Integer.parseInt(temp[1]);
            int k = Integer.parseInt(temp[2]);

            for (int b = i; b <= j; b++) {
                arr[b] = k;
            }
        }

        for(int i = 1; i <= n; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}