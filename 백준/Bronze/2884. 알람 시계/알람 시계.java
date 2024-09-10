import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        m -= 45;
        if(m<0){
            h--;
            m+=60;
            if(h<0){
                h = 23;
            }
        }

        System.out.println(h + " " + m);


    }
}