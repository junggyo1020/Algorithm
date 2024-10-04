import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        // "." 만 입력될 때 까지 반복
        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> st = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '(' || ch == '[') {
                    st.push(ch);
                }
                if (ch == ')') {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        flag = false;
                    }
                }
                if (ch == ']') {
                    if (!st.isEmpty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        flag = false;
                    }
                }
            }

            // 스택이 비어있지 않다면 flag = false
            if (!st.isEmpty()) {
                flag = false;
            }

            // flag에 따라 분기 처리
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
