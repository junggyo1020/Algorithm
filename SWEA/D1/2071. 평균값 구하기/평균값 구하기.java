import java.util.*;
import java.io.*;

class Solution
{
    static final int NUM = 10;
    static double sum;
    static double avg;
    
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sum = 0;
            avg = 0;
			for(int i = 0; i < NUM; i++){
            	sum += sc.nextInt();
            }
            avg = sum / NUM;
            avg = Math.round(avg);
           	System.out.format("#%d %.0f\n", test_case, avg);
		}
        sc.close();
	}
}