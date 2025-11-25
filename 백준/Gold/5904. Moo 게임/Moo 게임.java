import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int N;
    static char answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int k = 0;
        int curLen = 3; //s[0];

        while(curLen < N) { //현재 길이가 N이 넘어가지 않도록!
            k++;
            curLen = curLen * 2 + (k + 3); //m 1개 o k+2개
        }

        solve(k, curLen, N);

        System.out.println(answer);
    }

    private static void solve(int k, int totalLen, int n) {
        //기저 조건
        if(k == 0) {
            if(n == 1) answer = 'm';
            else answer = 'o';
            return;
        }

        //totalLen = prevLen * 2 + (k+3);
        int prevLen = (totalLen - (k+3)) / 2;
        int midLen = k+3;

        //왼쪽에 있는 경우
        if(n <= prevLen) {
            solve(k-1, prevLen, n);
        }
        //가운데 있는 경우
        else if(prevLen < n && n <= prevLen + midLen) {
            if(n - prevLen == 1) answer = 'm';
            else answer = 'o';
        }
        //오른쪽에 있는 경우
        else {
            solve(k-1, prevLen, n - (prevLen + midLen)); //왼쪽에 있는 내용의 인덱스로 맞춰주기
        }
    }
}