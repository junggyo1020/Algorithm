import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int max = Integer.parseInt(br.readLine());
        int idx = 1;

        for (int i = 2; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) {
                max = num;
                idx = i;
            }
        }

        bw.write(max + "\n" + (idx) + "\n");

        bw.flush();
        bw.close();
    }
}