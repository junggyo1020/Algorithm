import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum = 0;
            int[] arr = new int[10];
            for(int i = 0; i < 10; i++){
                arr[i] = sc.nextInt();
            }
            
            for(int i : arr){
                if(i % 2 != 0){
                    sum += i;
                }
            }
            
            System.out.println("#" + test_case + " " + sum);
		}
	}
}