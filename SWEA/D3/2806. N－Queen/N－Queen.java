import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    private static int n;
    private static int[] board;
    private static int count;
    
    private static void solveQueen(int row){
    	// 종료 조건
        if(row == n){ // n열까지 다 두었다는 것은 경우의 수가 존재한다는 것
        	count++;
            return;
        }
        
        for(int col = 0; col < n; col++){
        	if(isSafe(row,col)){ // 해당 열에 퀸을 둘 수 있는지 검사
            	board[row] = col; // 해당 열에 퀸 두기
                solveQueen(row+1); // 다음열에 퀸 두기
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
            n = sc.nextInt(); //체스판의 크기
            board = new int[n]; //Queen의 위치
			count = 0; //경우의 수
            solveQueen(0); //퀸 두기
            
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}