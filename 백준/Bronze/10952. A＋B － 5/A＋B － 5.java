import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] test = br.readLine().split(" ");
            int a = Integer.parseInt(test[0]);
            int b = Integer.parseInt(test[1]);
            if ((a == b) && (a == 0)) {
                break;
            }
            bw.write(String.format("%d\n", a + b));
        }

        bw.flush();
        bw.close();
    }
}