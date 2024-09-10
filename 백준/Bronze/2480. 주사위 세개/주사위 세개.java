import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        int price = 0;
        int max = 0;
        if(a==b){
            if(b==c) price = 10000 + a*1000; //a==b==c
            else price = 1000 + a*100; //a==b b!=c
        } else if(a==c) { // a!=b a==c
            price = 1000 + c*100;
        } else if(b==c){ // a!=b b==c
            price = 1000 + b*100;
        } else {
            max = Math.max(a,b) == a ? Math.max(a,c) : Math.max(b,c);
            price = max * 100;
        }

        System.out.println(price);

    }
}