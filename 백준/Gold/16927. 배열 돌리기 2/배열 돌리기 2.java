import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int[][] arr;
	static int n, m, r;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//Layer 별로 계산
		int num_layers = Math.min(n, m)/2;
		for(int l = 0; l < num_layers; l++) {
			rotateLayer(l);
		}
		
		//결과 출력
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
	}
	
	//R회 반시계 방향으로 회전
	private static void rotateLayer(int l) {
		int r1 = l;
		int r2 = n - l - 1;
		int c1 = l;
		int c2 = m - l - 1;
		
		List<Integer> list = new ArrayList<>();
		
		//레이어 별 list에 저장
		//위쪽
		for(int j = c1; j < c2; j++) {
			list.add(arr[r1][j]);
		}
		//오른쪽
		for(int i = r1; i < r2; i++) {
			list.add(arr[i][c2]);
		}
		//아래쪽
		for(int j = c2; j > c1 ; j--) {
			list.add(arr[r2][j]);
		}
		//왼쪽
		for(int i = r2; i > r1; i--) {
			list.add(arr[i][c1]);
		}
		
		if(list.isEmpty()) {
			return;
		}
		
		//회전 수
		int actual_rotate = r % list.size();
		Collections.rotate(list, -actual_rotate);
		
		//다시 원래대로 가져다놓기
		int idx = 0;
		for(int j = c1; j < c2; j++) {
			arr[r1][j] = list.get(idx++);
		}
		//오른쪽
		for(int i = r1; i < r2; i++) {
			arr[i][c2] = list.get(idx++);
		}
		//아래쪽
		for(int j = c2; j > c1 ; j--) {
			arr[r2][j] = list.get(idx++);
		}
		//왼쪽
		for(int i = r2; i > r1; i--) {
			arr[i][c1] = list.get(idx++);
		}
	}

}
