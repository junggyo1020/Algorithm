import jdk.jshell.execution.Util;

import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int a = 1; a <= m; a++) {
            String[] idx = br.readLine().split(" ");
            int i = Integer.parseInt(idx[0]);
            int j = Integer.parseInt(idx[1]);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();

    }
}