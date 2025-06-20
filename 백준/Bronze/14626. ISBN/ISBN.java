import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//14626
class Main {

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] arr = new int[12];
        int idx = -1;
        for (int i = 0; i < 12; i++) {
            char ch = line.charAt(i);
            if (ch == '*') {
                arr[i] = 0;
                idx = i;
            } else {
                arr[i] = ch - '0';
            }
        }
        int target = line.charAt(12) - '0';

        //2. sum 구하기
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (i % 2 == 0) ? arr[i] : arr[i] * 3;
        }

        //3. 0~9까지 모두 대입해보자.
        for (int answer = 0; answer <= 9; answer++) {
            int testSum = sum;
            testSum += (idx % 2 == 0) ? answer : answer * 3;
            if ((testSum + target) % 10 == 0) {
                System.out.println(answer);
                break;
            }
        }
    }
}