import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] exam = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String ex : exam) {
            if(s.contains(ex)){
                s = s.replace(ex, "*");
            }
        }

        bw.write(s.length() + "\n");
        bw.flush();
        bw.close();
    }
}