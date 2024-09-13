import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];
        int max_idx_x = -1;
        int max_idx_y = -1;
        int max_val = -1;
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(input[j]);
                if(max_val < num){
                    max_val = num;
                    max_idx_x = i+1;
                    max_idx_y = j+1;
                }
            }
        }

        bw.write(max_val + "\n" + max_idx_x + " " + max_idx_y);

        bw.flush();
        bw.close();
    }
}