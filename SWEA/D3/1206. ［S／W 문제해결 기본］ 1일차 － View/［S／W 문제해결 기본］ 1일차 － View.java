import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
			int[] arr = new int[N+1];
            int totalBuilding = 0;
            for(int i = 0; i < N; i++){
            	arr[i] = sc.nextInt();
            }
           
            // 조망권이 확보된 빌딩 구하기
            for(int i = 2; i < N-2; i++){
            	if(arr[i-2] < arr[i] && arr[i-1] < arr[i] && arr[i+1] < arr[i] && arr[i+2] < arr[i]){
                	// 최대값 찾기
                    int maxValue = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+1], arr[i+2]));
                    totalBuilding += (arr[i] - maxValue);
                }
            }
            
            System.out.println("#" + test_case + " " + totalBuilding);
		}
        sc.close();
	}
}