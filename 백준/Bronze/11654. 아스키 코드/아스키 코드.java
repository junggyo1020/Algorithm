import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char s = br.readLine().charAt(0);
        System.out.println((int) s);

//        bw.flush();
//        bw.close();
    }
}