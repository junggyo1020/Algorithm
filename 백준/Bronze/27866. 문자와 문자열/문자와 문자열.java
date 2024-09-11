import java.io.*;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        bw.write(str.charAt(n - 1) + "\n");
        bw.flush();
        bw.close();
    }
}