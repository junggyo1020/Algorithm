import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] arr = new int[26];
    static int odd, num;
    static String result;

    public void solution(String str) {
        //알파벳 개수 새기
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'A']++;
        }

        //홀수 횟수의 알파벳 개수 세기
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if (odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        //팰린드롬 앞부분 채우기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i] / 2; j++){
                sb.append((char)(i + 'A'));
            }
        }

        result = sb.toString();

        //가운데 문자 넣기
        if (odd == 1) {
            result += (char)(num + 'A');
        }

        //뒤에 문자열 뒤집어서 넣기
        result += sb.reverse().toString();

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        T.solution(str);
    }
}