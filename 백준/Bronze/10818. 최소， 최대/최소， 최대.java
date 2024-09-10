import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int max = Integer.parseInt(s[0]);
        int min = Integer.parseInt(s[0]);

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }

        bw.write(min + " " + max + "\n");

        bw.flush();
        bw.close();
    }
}