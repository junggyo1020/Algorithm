import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = "";
        while((input = br.readLine()) != null){
            String[] test = input.split(" ");
            int a = Integer.parseInt(test[0]);
            int b = Integer.parseInt(test[1]);
            bw.write((a+b) + "\n");
        }

        bw.flush();
        bw.close();
    }
}