import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
            int count = 0;
            int prev = '0';
            for(int i = 0; i < s.length(); i++){
            	int curr = s.charAt(i);
                if(curr != prev){
                	count++;
                    prev = curr;
                }
            }
           	System.out.printf("#%d %d\n", test_case, count);
		}
        sc.close();
	}
}