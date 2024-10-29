import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int n, m;
    static int[][] arr;
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][n];
            
            // 입력
            for(int i = 0; i < n; i++){
            	for(int j = 0; j < n; j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            
            // 한번에 잡는 모기의 수 구하기
            int maxMosquitoes = 0;
            for(int i = 0; i < n-m+1; i++){
            	for(int j = 0; j < n-m+1; j++){
                	int sum = 0;
                    
                    for(int x = i; x < i + m; x++){
                    	for(int y = j; y < j + m; y++){
                        	sum += arr[x][y];
                        }
                    }
                    
                    maxMosquitoes = Math.max(maxMosquitoes, sum);
                }
            }
            
            System.out.println("#" + test_case + " " + maxMosquitoes);
		}
        sc.close();
	}
}