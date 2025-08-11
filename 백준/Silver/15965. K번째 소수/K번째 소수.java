import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int MAX = 8_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		boolean[] isNotPrime = new boolean[MAX+1];
		//소수 구하기
		int cnt = 0;
		for(int i = 2; i <= MAX; i++) {
			if(!isNotPrime[i]) {
				cnt++;
				if(cnt == k) {
					System.out.println(i);
					return;
				}
				for(long j = (long)i*i; j <= MAX; j+=i) {
					isNotPrime[(int)j] = true;
				}
			}
		}
	}

}
