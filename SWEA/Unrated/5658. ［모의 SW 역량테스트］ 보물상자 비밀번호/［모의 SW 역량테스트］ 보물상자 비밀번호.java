import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 보물상자 비밀번호
 * 성능:
 * @author 서울_7반_정정교
 *
 */
public class Solution {
	
	static StringTokenizer st;
	static TreeSet<Integer> ts;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ts = new TreeSet<>(Collections.reverseOrder());
			
			String str = br.readLine();
			// N/4개 단위로 분할
			for(int i = 0; i < N/4; i++) {
				int len = N/4;
				for(int j = 0; j < 4; j++) {
					String num = str.substring(len*j, len*(j+1));
					ts.add(Integer.parseInt(num, 16));
				}
				
				//시계방향으로 회전
				str = str.substring(N - 1) + str.substring(0, N - 1);
			}
			
			//K번째 큰 수 구하기
			int answer = 0;
			for(int i = 0; i < K; i++) {
				answer = ts.pollFirst();
			}
			
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb);
		}
	}
}
