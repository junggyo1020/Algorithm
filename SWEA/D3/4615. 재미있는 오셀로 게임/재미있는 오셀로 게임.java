import java.util.*;
import java.io.*;
class Solution
{
    private static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int[][] board;
    
    private static void flip(int y, int x, int color, int n){
    	for(int d = 0; d < 8; d++){
        	int ny = y + dy[d];
            int nx = x + dx[d];
            boolean canFlip = false;
            List<int[]> toFlip = new ArrayList<>(); //뒤집어야 할 노드의 좌표
            
            while(ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] != 0 && board[ny][nx] != color){ // 다른 컬러가 있는 경우
            	toFlip.add(new int[] {ny, nx});
                ny += dy[d];
				nx += dx[d];
            }
            
            if(ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == color){
            	canFlip = true;
            }
            
            if(canFlip){
            	for(int[] pos : toFlip){
                	board[pos[0]][pos[1]] = color;
                }
            }
        }
    }
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            
            // 초기화
                int mid = n / 2;
                board[mid-1][mid-1] = 2;
                board[mid][mid] = 2;
                board[mid-1][mid] = 1;
                board[mid][mid - 1] = 1;
            
            for(int i = 0; i < m; i++){
            	st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1; // 1-index
                int y = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());
                
                board[y][x] = color;
                flip(y, x, color, n); // 뒤집기
            }
            
            int b_count = 0, w_count = 0;
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	if(board[i][j] == 1){
                    	b_count++;
                    } else if(board[i][j] == 2){
                    	w_count++;
                    }
                }
            }
            
            System.out.printf("#%d %d %d\n", test_case, b_count, w_count);
        }
    }
}