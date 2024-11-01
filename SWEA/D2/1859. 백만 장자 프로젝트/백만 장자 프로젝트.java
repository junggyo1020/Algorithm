
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
			int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            
            long totalSum = 0;
            int maxValue = arr[N-1];
            for(int i = N-2; i >= 0; i--){
                if(maxValue > arr[i]){
                	totalSum += (maxValue - arr[i]);
                } else {
                	maxValue = arr[i];
                }
            }
            
            System.out.println("#" + test_case + " " + totalSum);
		}
	}
}