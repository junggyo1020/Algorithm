import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] farm = new int[n][n];
            int sum = 0;
            int center = n/2;
            
            for(int i = 0; i < n; i++){
            	String s = sc.next();
               	for(int j = 0; j < n; j++){
                	farm[i][j] = s.charAt(j) - '0';
                }
            }
            
            for(int i = 0; i < n; i++){
            	int start = Math.abs(center - i);
                int end = n - start;
                
                for(int j = start; j < end; j++){
                	sum += farm[i][j];
                }
            }
            
            System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}