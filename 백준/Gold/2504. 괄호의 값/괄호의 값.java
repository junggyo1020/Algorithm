import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static ArrayDeque<Character> st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		st = new ArrayDeque<>();
		int tmp = 1;
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				tmp *= 2;
				st.push(c);
			} else if(c == '[') {
				tmp *= 3;
				st.push(c);
			} else if(c == ')') {
				if(st.isEmpty() || st.peek() != '(') {
					result = 0;
					break;
				}

				if(str.charAt(i-1) == '(') {
					result += tmp;
				}
				st.pop();
				tmp /= 2;
			} else if(c == ']') {
				if(st.isEmpty() || st.peek() != '[') {
					result = 0;
					break;
				}

				if(str.charAt(i-1) == '[') {
					result += tmp;
				}
				st.pop();
				tmp /= 3;
			}
		}

		if(!st.isEmpty()) {
			result = 0;
		}

		System.out.println(result);
	}
}
