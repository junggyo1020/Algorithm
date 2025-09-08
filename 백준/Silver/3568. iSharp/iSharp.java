import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//세미콜론 제거
		str = str.substring(0, str.length()-1);

		//쉼표 제거
		str = str.replace(',', ' ');

		//하나이상의 공백 제거
		String[] s = str.trim().split("\\s+");

		String one = s[0]; //기본 자료형

		for(int i = 1; i < s.length; i++){
			StringBuilder alpha = new StringBuilder();
			StringBuilder form = new StringBuilder();
			for(char ch : s[i].toCharArray()){
				if(Character.isAlphabetic(ch)){
					alpha.append(ch);
				} else {
					if(ch == '[') form.append(']');
					else if(ch == ']') form.append('[');
					else form.append(ch);
				}
			}
			System.out.println(one + form.reverse() + " " + alpha + ";");
		}
	}
}
