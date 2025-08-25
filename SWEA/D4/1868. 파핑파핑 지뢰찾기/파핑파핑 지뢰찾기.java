import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [D4] 파핑파핑 지뢰 찾기
 * @author 서울_7반_정정교
 *
 * 칸을 클릭한다
 * - 지뢰가 있는 칸 => "파핑 파핑!" 출력 후 종료
 * - 지뢰가 없는 칸
 *  => '.'였던 칸을 'c'로 변경
 *  => +1 범위 안에 최대 8칸에 대해 각각 몇 개의 지뢰가 있는지 0-8 사이 숫자로 표시된다.
 * 
 * 지뢰 '*', 일반 칸 '.'
 * 
 * 클릭 수를 어떻게 하면 최소화 할 수 있을까?
 * - 우선 단순 완탐이 가능할까?
 * - 300*300 = 9만번
 * - 0인 경우 확장해서 땅을 미리 제거할 수 있기 때문에 0부터 찾자!
 */
public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, answer;
	static char[][] map;
	static int[][] mapCnt;
	static boolean[][] visited;
	
	static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			input();
			sb.append("#").append(t).append(" ");
			solve();
		}
        System.out.println(sb);
	}
	
	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		mapCnt = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '*') {
					mapCnt[i][j] = -1;
					visited[i][j] = true;
					continue;
				}
				
				int cnt = 0;
				for(int d = 0; d < 8; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
					if(map[ny][nx] == '*') cnt++;
				}
				mapCnt[i][j] = cnt;
			}
		}
	}
	
	private static void solve() {
		//mapCnt가 0인 경우부터 찾기
		answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(mapCnt[i][j] == 0 && !visited[i][j]) {
					answer++;
					bfs(i, j);
				}
			}
		}
		
		//mapCnt가 0이 아닌 경우
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(mapCnt[i][j] != 0 && !visited[i][j]) {
					answer++;
					visited[i][j] = true;
				}
			}
		}
		
		sb.append(answer).append("\n");
	}
	
	private static void bfs(int y, int x) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			for(int d = 0; d < 8; d++) {
				int ny = curY + dy[d];
				int nx = curX + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					if(mapCnt[ny][nx] == 0) {
						q.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
}
