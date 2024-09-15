import java.io.*;
import java.util.Arrays;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        //소수 찾기
        for (int i = 2; i * i <= 1000; i++) {
            if(isPrime[i]){
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        //주어진 수들 중 소수의 개수 출력
        int cnt = 0;
        for(String i : input){
            if(isPrime[Integer.parseInt(i)]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}