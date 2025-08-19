import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int H, W, y, x; //게임 맵의 높이와 너비, 시작좌표(y,x);
	static char[][] map; //게임 맵 정보
	static int N;
	
	static final char[] tankShape = {'^', 'v', '<', '>'};
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						//시작지점 저장
						y = i;
						x = j;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			for(char ch : br.readLine().toCharArray()) {
				int dir = 0;
				
				switch(ch) {
					case 'U':
						dir = 0;
						map[y][x] = tankShape[dir];
						break;
					case 'D':
						dir = 1;
						map[y][x] = tankShape[dir];
						break;
					case 'L':
						dir = 2;
						map[y][x] = tankShape[dir];
						break;
					case 'R':
						dir = 3;
						map[y][x] = tankShape[dir];
						break;
					case 'S':
						shoot();
						continue;
				}
				
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				
				if(ny >= 0 && ny < H && nx >= 0 && nx < W && map[ny][nx] == '.') {
					map[y][x] = '.';
					y = ny;
					x = nx;
					map[y][x] = tankShape[dir];
				}
			}
			sb.append("#").append(t).append(" ");
			print();
		}
		System.out.println(sb);
	}
	
	private static void print() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}
	
	private static void shoot() {
		int dir = 0;
		char cur = map[y][x];
		if(cur == '^') dir = 0;
		else if(cur == 'v') dir = 1;
		else if(cur == '<') dir = 2;
		else if(cur == '>') dir = 3;
		
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		
		while(ny >= 0 && ny < H && nx >= 0 && nx < W) {
			if(map[ny][nx] == '*') {
				map[ny][nx] = '.';
				break;
			} else if(map[ny][nx] == '#') {
				break;
			}
			
			ny += dy[dir];
			nx += dx[dir];
		}
	}
}
