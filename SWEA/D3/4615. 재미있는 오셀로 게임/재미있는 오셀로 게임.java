import java.util.*;
import java.io.*;
class Solution
{
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
   	static int[][] board;
    
    private static void flip(int x, int y, int color, int n){
    	for(int d = 0; d < 8; d++){
        	int ny = y + dy[d];
            int nx = x + dx[d];
            boolean isFlip = false; // 뒤집을 수 있는지 여부
            List<int[]> toFlip = new ArrayList<>(); // 뒤집어야할 노드의 좌표
            
            while(nx >=0 && nx < n && ny >=0 && ny < n && board[ny][nx] != 0 && board[ny][nx] != color){
                toFlip.add(new int[]{ny, nx});
                ny += dy[d];
                nx += dx[d];
            }
                
            if(nx >=0 && nx < n && ny >=0 && ny < n && board[ny][nx] == color){
               	isFlip = true;
            }
            
            if(isFlip){
            	for(int[] pos : toFlip){
				board[pos[0]][pos[1]] = color;
				}
            }
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= t; test_case++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            board = new int[n][n];
            
            // 초기 돌 두기
            int mid = n / 2;
			board[mid-1][mid-1] = 2;
            board[mid][mid] = 2;
            board[mid-1][mid] = 1;
            board[mid][mid-1] = 1;
            
            for(int i = 0; i < m; i++){
            	st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1; // 1-index
                int y = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());
                
                board[y][x] = color;
                flip(x, y, color, n);// 돌 뒤집기
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