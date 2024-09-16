import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 2;
        while(true){
            if(n==1){
                break;
            }
            if(n%cnt == 0){
                System.out.println(cnt);
                n /= cnt;
            } else {
                cnt++;
            }

        }
    }
}