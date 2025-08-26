import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++){
			String str = br.readLine();
			for(int j = 0; j < N; j++){
				board[i][j] = str.charAt(j) - '0';
			}
		}

		dfs(board, 0, 0, N, sb);

		System.out.println(sb);
	}

	private static void dfs(int[][] board, int y, int x, int size, StringBuilder sb){
		if(isSame(board, y, x, size)){
			sb.append(board[y][x]);
			return;
		} else {
			sb.append("(");
			dfs(board, y, x, size/2, sb);
			dfs(board, y, x + size/2, size/2, sb);
			dfs(board, y + size/2, x, size/2, sb);
			dfs(board, y+size/2, x+size/2, size/2, sb);
			sb.append(")");
		}
	}

	private static boolean isSame(int[][] board, int y, int x, int size){
		int cur = board[y][x];
		for(int i = y; i < y + size; i++){
			for(int j = x; j < x + size; j++){
				if(board[i][j] != cur) return false;
			}
		}
		return true;
	}
}
