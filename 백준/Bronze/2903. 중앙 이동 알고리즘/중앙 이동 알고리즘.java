import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 4;
        int prev_res = 4;
        int idx = 3;
        while (n>0) {
            result += idx * idx - prev_res;
            idx += (idx - 1);
            prev_res = result;
            n--;
        }
        System.out.println(result);
    }
}