import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().trim();

        if(input.isEmpty()){
            bw.write("0\n");
        } else {
            String[] str = input.split(" ");
            bw.write(str.length + "\n");
        }

        bw.flush();
        bw.close();
    }
}