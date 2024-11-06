import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    private static final int[] number = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[] result = new int[8];
            
            for(int i = 0; i < 8; i++){
            	while(n >= number[i]){
                	n -= number[i];
                    result[i]++;
                }
            }
            
            System.out.printf("#%d\n", test_case);
            for(int res : result){
            	System.out.print(res + " ");
            }
            System.out.println();
		}
	}
}