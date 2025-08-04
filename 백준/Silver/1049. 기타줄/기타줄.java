import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int many = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			many = Math.min(many, Integer.parseInt(st.nextToken()));
			one = Math.min(one, Integer.parseInt(st.nextToken()));
		}
		
		//묶음 개수
		int many_cnt = n / 6;
		//낱개 개수
		int one_cnt = n % 6;
		
		//1. 묶음  + 낱개
		int case_1 = many_cnt * many + one_cnt * one;
		
		//2. 묶음으로만 구매
		int case_2 = ((n+5) / 6) * many;
		
		//3. 낱개로만 구매
		int case_3 = one * n;
		
		System.out.println(Math.min(Math.min(case_1, case_2), case_3));
	}

}
