import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n==-1){
                break;
            }

            int sum = 0;
            List<Integer> arr = new ArrayList<>();

            for (int i = 1; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if(i!=n){
                        arr.add(i);
                        sum += i;
                    }
                    if (i != n / i && n / i != n) {
                        arr.add(n/i);
                        sum += n / i;
                    }
                }
            }

            Collections.sort(arr);

            if(sum == n) {
                System.out.print(n + " = ");
                for (int i = 0; i < arr.size(); i++) {
                    if (i != 0) {
                        System.out.print(" + ");
                    }
                    System.out.print(arr.get(i));
                }
                System.out.println();
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}