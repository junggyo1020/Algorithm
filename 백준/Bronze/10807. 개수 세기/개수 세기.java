import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(v==Integer.parseInt(line[i])) cnt++;
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
    }
}