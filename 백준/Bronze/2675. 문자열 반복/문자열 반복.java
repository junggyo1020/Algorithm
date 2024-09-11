import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int r = Integer.parseInt(inputs[0]);
            String s = inputs[1];

            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    bw.write(s.charAt(j));
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}