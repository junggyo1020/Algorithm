import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zero_cnt = 0, one_cnt = 0, prev = -1;
        for (char x : s.toCharArray()) {
            int tmp = x - '0';
            if (tmp != prev) {
                if(tmp == 0) zero_cnt++;
                if(tmp == 1) one_cnt++;
            }
            prev = tmp;
        }
        System.out.println(Math.min(zero_cnt, one_cnt));
    }
}