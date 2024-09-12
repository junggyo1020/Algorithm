import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] board = {1, 1, 2, 2, 2, 8};

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            int result = board[i] - Integer.parseInt(input[i]);
            bw.write(result + " ");
        }

        bw.flush();
        bw.close();
    }
}