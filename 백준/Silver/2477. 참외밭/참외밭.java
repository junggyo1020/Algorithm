import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static final int NUM = 6;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int[] a = new int[NUM]; //방향
		int[] b = new int[NUM]; //변의 길이
		
		int max_height = -1;
		int max_width = -1;
		
		//입력 & 큰 사각형 구하기
		for(int i = 0; i < NUM; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			
			//동 <> 서
			if(a[i] == 1 || a[i] == 2) {
				if(max_width < b[i]) max_width = b[i];
			} else { //남 <> 북
				if(max_height < b[i]) max_height = b[i];
			}
		}
		
		//작은 사각형 구하기
		/**
		 * 0 : 1->3
		 * 90 : 4->1
		 * 180 : 2->4
		 * 270 : 3->2
		 */
		int small_area = 0;
		for(int i = 0; i < NUM; i++) {
			int c_dir = a[i];
			int n_dir = a[(i+1)%NUM];
			//작은 사각형 변 구하기
			if(c_dir == 1 && n_dir == 3 || c_dir == 4 && n_dir == 1
				|| c_dir == 2 && n_dir == 4 || c_dir == 3 && n_dir == 2) {
				//작은 사각형의 넓이 구하기
				small_area = b[i] * b[(i+1) % NUM];
			}
		}
		
		
		System.out.println((max_width * max_height - small_area) * k);
	}

}
