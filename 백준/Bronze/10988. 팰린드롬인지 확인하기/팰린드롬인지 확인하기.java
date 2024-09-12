import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = new String(br.readLine());
        StringBuilder reverseInput = new StringBuilder(input).reverse();
        if(input.contentEquals(reverseInput)){
            bw.write(1 + "\n");
        } else {
            bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
    }
}