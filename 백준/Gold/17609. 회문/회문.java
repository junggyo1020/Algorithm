import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			checkPalindrome(str);
		}

		System.out.println(sb);
	}

	private static void checkPalindrome(String s) {
		int lt = 0;
		int rt = s.length() - 1;
		while(lt < rt) {
			if(s.charAt(lt) == s.charAt(rt)) {
				lt++;
				rt--;
			} else {
				boolean leftPalindrome = isPalindrome(s, lt+1, rt);
				boolean rightPalindrome = isPalindrome(s, lt, rt-1);
				if(leftPalindrome || rightPalindrome) {
					sb.append(1).append("\n");
					return;
				} else {
					sb.append(2).append("\n");
					return;
				}
			}
		}
		sb.append("0").append("\n");
		return;
	}

	private static boolean isPalindrome(String s, int lt, int rt) {
		while(lt < rt) {
			if(s.charAt(lt) == s.charAt(rt)) {
				lt++;
				rt--;
			} else {
				return false;
			}
		}
		return true;
	}
}
