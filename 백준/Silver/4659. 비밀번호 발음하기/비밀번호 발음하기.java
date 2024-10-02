import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Main {

    static int a_cnt, b_cnt, p_word;
    static boolean is_acceptable, has_a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!(input = br.readLine()).equals("end")) {

            // 테스트 케이스 별로 초기화
            has_a = false;
            is_acceptable = true;
            a_cnt = 0;
            b_cnt = 0;
            p_word = ' ';

            // 실험 진행
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                // 모음 입력 받음
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    a_cnt++;
                    b_cnt = 0; // 자음 개수는 초기화
                    has_a = true;
                } else { // 자음 입력 받음
                    b_cnt++;
                    a_cnt = 0;
                }

                // 모음이나 자음의 개수가 3개 이상 연속으로 오는 경우
                if (a_cnt >= 3 || b_cnt >= 3) {
                    is_acceptable = false;
//                    System.out.println(input + "은 자음 또는 모음이 3개 이상입니다.");
                    break;
                }

                // 겹치는 문자가 2개 이상인 경우 false
                if (ch == p_word && ch != 'e' && ch != 'o') {
                    is_acceptable = false;
//                    System.out.println(input + "은 겹치는 문자 " + ch + "가 2개 이상입니다.");
                    break;
                }

                p_word = ch;
            }

            // 모음을 하나도 포함하지 않는 경우
            if (!has_a) {
                is_acceptable = false;
//                System.out.println(input + "은 모음을 하나도 포함하지 않습니다.");
            }

            if (is_acceptable) {
                System.out.format("<%s> is acceptable.\n", input);
            } else {
                System.out.format("<%s> is not acceptable.\n", input);
            }
        }
    }
}
