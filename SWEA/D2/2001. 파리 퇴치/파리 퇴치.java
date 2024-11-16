
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int n, m;
    static int[][] fly;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            m = sc.nextInt();
            fly = new int[n][n];
            
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	fly[i][j] = sc.nextInt();
                }
            }
            
            int maxSum = 0;
            for(int i = 0; i < n-m+1; i++){
            	for(int j = 0; j < n-m+1; j++){
                    int sum = 0;
                	for(int k = i; k < i + m; k++){
                    	for(int l = j; l < j + m; l++){
                        	sum += fly[k][l];
                        }
                    }
                    maxSum = Math.max(maxSum, sum);
                }
            }
            
            System.out.printf("#%d %d\n", test_case, maxSum);
		}
        sc.close();
	}
}