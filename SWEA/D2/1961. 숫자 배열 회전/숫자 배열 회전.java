import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static int[][] board, arr90, arr180, arr270;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			//배열 입력
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//출력값 저장
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append('\n');
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++){
					sb.append(board[N-j-1][i]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++){
					sb.append(board[N-i-1][N-j-1]);
				}
				sb.append(" ");
				for(int j = 0; j < N; j++){
					sb.append(board[j][N-i-1]);
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}
}