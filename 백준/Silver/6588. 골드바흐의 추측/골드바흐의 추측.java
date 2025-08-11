import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int n;
	static boolean[] isNotPrime = new boolean[1000001];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 2; i <= 1000000; i++) {
			if(!isNotPrime[i]) {
				for(long j = (long)i*i; j <= 1000000; j+=i) {
					isNotPrime[(int)j] = true;
				}
			}
		}
		
		String input = null;
		while(!(input = br.readLine()).equals("0")) {
			n = Integer.parseInt(input);
			
			//하나를 뽑아 다른 하나가 소수인지 확인
			int max_num = -1;
			int ans_a = -1;
			int ans_b = -1;
			for(int i = 2; i < n; i++) {
				//a,b 둘다 소수이면
				if(!isNotPrime[i] && !isNotPrime[n-i]) {
					if(max_num < n-i-i) {
						max_num = n - i - i;
						ans_a = i;
						ans_b = n-i;
						break;
					}
				}
			}
			
			//결과 출력
			if(max_num != -1) {
				sb.append(n).append(" = ").append(ans_a).append(" + ").append(ans_b).append("\n");
			} else {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
		}
		System.out.println(sb);
	}

}
