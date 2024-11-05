import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    
   	private static final int[] dy = {0,1,0,-1};
    private static final int[] dx = {1,0,-1,0};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] snail = new int[n][n];
            int d = 0;
            int x = 0, y = 0;
            int number = 1;
            
            while(number <= n*n){
            	snail[y][x] = number++;
                
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny<0 || ny >= n || nx < 0 || nx >=n || snail[ny][nx] != 0){
                	d = (d+1) % 4;
                    ny = y + dy[d];
                    nx = x + dx[d];
                }
                
                y = ny;
                x = nx;
            }
            
            System.out.printf("#%d\n", test_case);
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}