import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 격자판의 숫자 이어 붙이기
 * 성능: 
 * @author 서울_7반_정정교
 *
 * 첫번쨰 방식 : dfs를 돌면서 String에 방문한 숫자를 더하고, Set에 저장한 다음 Set의 크기를 출력한다.
 */
public class Solution {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] board;
	static Set<String> hS;
	static ArrayList<Integer> list;
	
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			board = new int[4][4];
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//인접한 격자로 총 6번 이동하기
			hS = new HashSet<>();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					list = new ArrayList<>();
					list.add(board[i][j]);
					dfs(i, j, list);
				}
			}
			
			sb.append("#").append(t).append(" ").append(hS.size()).append("\n");
			
		} //end TestCase
		
		System.out.println(sb);
	} // end main
	
	private static void dfs(int y, int x, ArrayList<Integer> list) {
		if(list.size() == 7) {
			StringBuilder sb = new StringBuilder();
			for(int o : list) {
				sb.append(o);
			}
			
			hS.add(sb.toString());
			return;
		}
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || ny>=4 || nx<0 || nx>=4) continue;
			list.add(board[ny][nx]);
			dfs(ny, nx, list);
			list.remove(list.size()-1);
		}
	}
}
