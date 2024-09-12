import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int t = 0; t < n; t++) {
            String str = br.readLine();
            boolean[] alp = new boolean[26];
            alp[str.charAt(0) - 'a'] = true;
            boolean flag = false;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(i - 1)) {
                    if (alp[str.charAt(i) - 'a']) {
                        flag = true;
                        break;
                    } else {
                        alp[str.charAt(i) - 'a'] = true;
                    }
                }
            }
            if(!flag){
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}