import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] students = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            students[idx] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if(!students[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}