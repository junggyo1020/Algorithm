import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       //1(1) 2~7(6) 8~19(12) 20~37(18) 38~61(24) ...
        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(1);
            return;
        }

        int layer = 1;
        int range = 2;

        while(range <= n){
            range += (6*layer);
            layer++;
        }

        System.out.println(layer);
    }
}