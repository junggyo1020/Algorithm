import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Stack<Character> st = new Stack<>();
            String s = br.readLine();
            boolean isValid = true;
            for (char x : s.toCharArray()) {
                if (x == '(') {
                    st.push(x);
                } else {
                    if (st.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    st.pop();
                }
            }
            System.out.println(isValid && st.isEmpty()? "YES" : "NO");
        }
    }
}