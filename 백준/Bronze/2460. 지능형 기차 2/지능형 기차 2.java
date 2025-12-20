import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());

			//현재 사람 수 계산
			count -= out; //내리고
			count += in; //탄다
			
			//현재가 최대 사람 수 인지 비교
			if(max < count) {
				max = count;
			}
		}

		//열 번째 줄까지 계산 후 최대값 출력
		System.out.println(max);
	}
}
