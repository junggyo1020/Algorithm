import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String[] result = {"", ""};
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j >= 0; j--) {
                result[i] += String.valueOf(input[i].charAt(j));
            }
        }

        int max = Math.max(Integer.parseInt(result[0]), Integer.parseInt(result[1]));
        bw.write(max + "\n");
        
        bw.flush();
        bw.close();
    }
}