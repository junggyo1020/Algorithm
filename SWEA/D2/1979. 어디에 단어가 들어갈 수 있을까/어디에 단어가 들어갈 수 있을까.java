
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int n, k;
    static int[][] puzzle;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = sc.nextInt();
            k = sc.nextInt();
            puzzle = new int[n][n];
            int cnt = 0;
            
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	puzzle[i][j] = sc.nextInt();
                }
            }
            
            //가로 행 검사
            for(int i = 0; i < n; i++){
            	int length = 0;
                for(int j = 0; j < n; j++){
                	if(puzzle[i][j] == 1){
                    	length++;
                    } else {
                    	if(length == k){
                        	cnt++;
                        }
                        length = 0;
                    }
                }
                if(length == k) cnt++;
            }
            
            //세로 행 검사
            for(int i = 0; i < n; i++){
            	int length = 0;
                for(int j = 0; j < n; j++){
                	if(puzzle[j][i] == 1){
                    	length++;
                    } else {
                        if(length == k){
                        	cnt++;
                        }
                        length = 0;
                    }
                }
                if(length == k) cnt++;
            }
            
            System.out.printf("#%d %d\n", test_case, cnt);
		}
        sc.close();
	}
}