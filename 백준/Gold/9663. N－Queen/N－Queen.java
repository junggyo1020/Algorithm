import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 퀸을 놓을 수 있는지 확인하는 것
 * 1. 일단 하나의 행에서 하나 둔다.
 * 2. 다음 행에서 조건을 본다.
 * 	- 같은 열에 퀸이 존재하는 지
 * 	- 대각선에 퀸이 존재하는 지
 * 3. 조건을 만족하면 퀸을 둔다.
 * 4. 둔 개수가 N개인 경우만 출력한다.
 */
public class Main {

	static int N;
	static int[] cols;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		cols = new int[N];
		nQueens(0);

		System.out.println(answer);
	}

	private static void nQueens(int row){
		if(row == N) {
			answer++;
			return;
		}

		for(int col = 0; col < N; col++){
			cols[row] = col;
			if(isSafe(row)){
				nQueens(row+1);
			}
		}
	}

	private static boolean isSafe(int row){
		for(int i = 0; i < row; i++){
			// 같은 열에 있는지
			if(cols[i] == cols[row]){
				return false;
			}

			// 같은 대각선에 있는지
			if(Math.abs(row - i) == Math.abs(cols[row] - cols[i])){
				return false;
			}
		}

		return true;
	}
}
