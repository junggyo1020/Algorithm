import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int SIZE = 100;
	static final int TEST_SIZE = 10;
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	static StringBuilder sb = new StringBuilder();
	static int sy, sx, ey, ex;
	static int[][] maze;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= TEST_SIZE; t++) {
			br.readLine();
			//#1. 100*100 배열 입력받기
			maze = new int[SIZE][SIZE];
			visited = new boolean[SIZE][SIZE];
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				for(int j = 0; j < 100; j++) {
					int num = str.charAt(j) - '0';
					maze[i][j] = num;
					if(num == 2) {
						sy = i;
						sx = j;
					} else if(num == 3) {
						ey = i;
						ex = j;
					}
				}
			}
			
			//#2. 도달 가능여부 체크
			boolean check = dfs(sy, sx);
			sb.append("#").append(t).append(" ").append(check ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean dfs(int y, int x) {
		visited[y][x] = true;
		if(maze[y][x] == 3) return true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= SIZE || nx < 0 || nx >= SIZE) continue;
			
			if(!visited[ny][nx] && maze[ny][nx] != 1) {
				if(dfs(ny, nx)) {
					return true;
				}
			}
		}
		return false;
	}
}
