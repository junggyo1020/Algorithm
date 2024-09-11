import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            bw.write(String.format("%C%C\n", str.charAt(0), str.charAt(str.length() - 1)));
        }

        bw.flush();
        bw.close();
    }
}