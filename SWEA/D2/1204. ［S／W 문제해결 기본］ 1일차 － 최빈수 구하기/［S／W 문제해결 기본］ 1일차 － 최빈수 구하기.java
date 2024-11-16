import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final int n = 1000;
    static int[] score;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
            score = new int[101];
            int maxVal = 0;
            int result = 0;
            
            for(int i = 0; i < n; i++){
            	score[sc.nextInt()]++;
            }
            
            for(int i = 100; i >= 0; i--){
            	if(score[i] > maxVal) {
                    maxVal = score[i];
                    result = i;
                }
            }
            
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}