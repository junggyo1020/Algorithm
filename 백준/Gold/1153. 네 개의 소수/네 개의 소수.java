import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static boolean[] isPrime;

    private static void sieve() {
        isPrime = new boolean[1_000_001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i <= 1_000_000; i++) {
            if(isPrime[i]) {
                for(long j = (long)i*i; j <= 1_000_000; j+=i) {
                    isPrime[(int)j] = false;
                }
            }
        }
    }

    //골드바흐의 추축 : 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sieve();

        if(N < 8) {
            System.out.println(-1);
            return;
        }

        //골드바흐의 추측에 의해 4개의 소수가 아닌 2개 + 2개의 소수를 구한다고 생각하자.
        //어짜피 2보다 큰 짝수라면, 두 소수의 합으로 무조건 구할 수 있다.
        //앞에 두개를 가장 간단한 2개의 소수 합으로 정하고, 뒤의 소수를 정하는 아이디어.
        StringBuilder sb = new StringBuilder();
        if(N%2 == 0) {
            sb.append("2 2 ");
            N -= 4;
        } else {
            sb.append("2 3 ");
            N -= 5;
        }

        //나머지 두개의 소수 찾기
        for(int p1 = 2; p1 <= N; p1++) {
            int p2 = N - p1;
            if(isPrime[p1] && isPrime[p2]) {
                sb.append(p1).append(" ").append(p2).append("\n");
                System.out.println(sb);
                return;
            }
        }
    }
}
