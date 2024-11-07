import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int[] board;
    static int n;
    static int count;
    
    private static void solveQueen(int row){
    	if(row == n){
        	count++;
			return;
        }
        
        for(int col = 0; col < n; col++){
        	if(isSafe(row,col)){
            	board[row] = col;
                solveQueen(row+1);
            }
        }
    }
    
    private static boolean isSafe(int row, int col){
    	for(int i = 0; i < row; i++){
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = sc.nextInt();
            board = new int[n];
            count = 0; // 경우의 수
            solveQueen(0); // 0행 부터 퀸 놓기
            
            System.out.printf("#%d %d\n", test_case, count);
		}
	}
}