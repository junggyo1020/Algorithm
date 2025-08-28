import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 벽돌깨기
 * 성능:
 * @author 서울_7반_정정교
 *
 */
public class Solution {

	static int N, W, H, minBricks;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            minBricks = Integer.MAX_VALUE;
            dfs(0, map);

            sb.append("#").append(t).append(" ").append(minBricks).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cnt, int[][] map) {
    	if(cnt == N) {
    		//남아있는 벽돌 수가 작은 것으로 업데이트
    		minBricks = Math.min(minBricks, countBricks(map));
    		return;
    	}
    	
    	//남은 벽돌수가 이미 0개인 경우
    	if(minBricks == 0) return;
    	
    	//모든 열에 대해 벽돌 떨어뜨려보기
    	for(int c=0; c<W; c++) {
    		//map 깊은복사
        	int[][] nextMap = copy(map);
        	
    		int r = -1;
    		
    		for(int h=0; h<H; h++) {
    			if(nextMap[h][c] != 0) {
    				r = h;
    				break;
    			}
    		}
    		
    		if (r != -1) {
    		    explode(nextMap, r, c); //벽돌 깨기
    		    reArrange(nextMap); //map 재정렬
    		}
    		
    		//재귀
    		dfs(cnt+1, nextMap);
    	}
    }
    
    private static int countBricks(int[][] map) {
    	int cnt = 0;
    	for(int r = 0; r < H; r++) {
    		for(int c = 0; c < W; c++) {
    			if(map[r][c] != 0) cnt++;
    		}
    	}
    	return cnt;
    }
    
    private static int[][] copy(int[][] oMap){
    	int[][] nMap = new int[H][W];
    	for(int h = 0; h < H; h++) {
    		System.arraycopy(oMap[h], 0, nMap[h], 0, W);
    	}
    	return nMap;
    }
    
    private static void explode(int[][] map, int r, int c) {
    	Queue<int[]> q = new ArrayDeque<>();
    	if(map[r][c] > 0) {
    		q.offer(new int[] {r, c, map[r][c]});
    		map[r][c] = 0;
    	}
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int p = cur[2];
    		
    		for(int i = 0; i < 4; i++) {
    			for(int j = 1; j < p; j++) {
    				int ny = y + dr[i]*j;
        			int nx = x + dc[i]*j;
        			
        			if(ny<0 || ny>=H || nx<0 || nx>=W) continue;
        			if(map[ny][nx] != 0) {
        				q.offer(new int[] {ny, nx, map[ny][nx]});
        				map[ny][nx] = 0;
        			}
    			}
    		}
    	}
    }
    
    private static void reArrange(int[][] map) {
    	for(int c = 0; c < W; c++) {
    		Stack<Integer> st = new Stack<>();
    		
    		for(int r = 0; r < H; r++) {
    			if(map[r][c] != 0) {
    				st.push(map[r][c]);
    				map[r][c] = 0;
    			}
    		}
    		
    		int h = H-1;
    		while(!st.isEmpty()) {
    			map[h--][c] = st.pop();
    		}
    	}
    }
}