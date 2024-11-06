/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
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
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
            	arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            StringBuilder answer = new StringBuilder();
            for(int a : arr){
            	answer.append(Integer.toString(a)).append(" ");
            }
            System.out.printf("#%d %s\n", test_case, answer.toString());
		}
	}
}