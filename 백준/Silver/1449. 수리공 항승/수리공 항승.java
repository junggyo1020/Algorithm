import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		//물 새는 곳 기록
		boolean[] arr = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num] = true;
		}
		
		//물이 샐 경우 테이프 붙이기
		int cnt = 0;
		for(int i = 1; i <= 1000; i++) {
			if(arr[i]) {
				for(int j = i; j < i + l; j++) {
					if(j > 1000) continue; //테이프가 넘어가면 패스
					arr[j] = false;
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
