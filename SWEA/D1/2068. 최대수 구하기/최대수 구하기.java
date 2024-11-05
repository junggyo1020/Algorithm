import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
    private static final int NUM = 10;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int maxValue = Integer.MIN_VALUE;
			for(int i = 0; i < NUM; i++){
            	int temp = sc.nextInt();
                if(maxValue < temp) maxValue = temp;
            }
            System.out.println("#" + test_case + " " + maxValue);
		}
	}
}