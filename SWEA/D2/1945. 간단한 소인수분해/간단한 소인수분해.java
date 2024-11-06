
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
			int a = 0; int b = 0; int c = 0; int d = 0; int e = 0;
            int n = sc.nextInt();
            	while(n % 2 == 0){
                	n /= 2;
                    a++;
                }
                while(n % 3 == 0){
                	n /= 3;
                    b++;
                }
                while(n % 5 == 0){
                	n /= 5;
                    c++;
                }
                while(n % 7 == 0){
                	n /= 7;
                    d++;
                }
                while(n % 11 == 0){
                	n /= 11;
                    e++;
                }
                
				System.out.printf("#%d %d %d %d %d %d\n", test_case, a, b, c, d, e);
        }
        sc.close();
	}
}