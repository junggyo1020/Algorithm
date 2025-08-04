import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		//뒤집히는 숫자 개수 세기
		int one_cnt = 0;
		int zero_cnt = 0;
		int prev = S.charAt(0) - '0';
		
		//초기 증가
		if(prev == 1) one_cnt++;
		else zero_cnt++;
		
		for(char c : S.toCharArray()) {
			int num = c - '0';
			if(prev != num) {
				if(num == 1) one_cnt++;
				else zero_cnt++;
				prev = num;
			}
		}
		System.out.println(Math.min(zero_cnt, one_cnt));
	}

}
