import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(br.readLine());

        b += c;
        if(b >= 60){
            a+=(b/60);
            b%=60;
            if(a>=24){
                a = a%24;
            }
        }

        System.out.println(a + " " + b);

    }
}