import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static int minSum = Integer.MAX_VALUE;
    static int answerA, answerB;

    static class Point {
        int a, b;

        Point(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); //최대공약수
        B = Integer.parseInt(st.nextToken()); //최소공배수

        //1. 두개의 자연수 쌍이 없는 경우
        if(B % A != 0) System.out.println("만족하는 두 개의 자연수가 없습니다!");

        //2. 두 개의 자연수 쌍 찾기
        //2-1. m*n 구하기
        int P = B/A;
        //2-2. 곱해서 P가 되는 쌍 찾기
        for(int i = 1; (long)i * i <= P; i++) { //오버플로우 주의!
            if(P%i == 0) {
                if(gcd(P/i, i) == 1) {
                    //두 자연수의 합이 최소가 되는 두 수
                    if(i + P/i < minSum){
                        minSum = i + P/i;
                        answerA = i * A;
                        answerB = P/i * A;
                    }
                }
            }
        }

        //3. 결과 출력하기
        System.out.println(answerA + " " + answerB);
    }
}
