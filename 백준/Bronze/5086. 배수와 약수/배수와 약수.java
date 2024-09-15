import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            if (n == 0 && m == 0) {
                break;
            }
            if (m % n == 0) {
                System.out.println("factor");
            } else if (n % m == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}