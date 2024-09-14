import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String n = input[0];
        int B = Integer.parseInt(input[1]);

        int result = 0;
        int pow = 1;
        int num;
        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            if ('A' <= c && c <= 'Z') {
                num = c - 'A' + 10;
            } else {
                num = c - '0';
            }
            result += num * pow;
            pow *= B;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}