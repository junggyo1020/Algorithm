import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Stack<Character> st = new Stack<>();
            String input = br.readLine();
            boolean flag = true;

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                // 입력 처리
                if (ch == '(') {
                    st.push(ch);
                } else {
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()){
                flag = false;
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
