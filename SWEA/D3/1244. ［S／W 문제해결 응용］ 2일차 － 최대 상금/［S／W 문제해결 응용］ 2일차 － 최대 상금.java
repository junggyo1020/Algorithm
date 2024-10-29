
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] arr;
    static int n;
    static int max = 0;
    
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = sc.next();
            n = sc.nextInt();
            arr = new int[s.length()];
            
            for(int i = 0; i < s.length(); i++){
            	arr[i] = s.charAt(i) - '0';
            }
            
            if(arr.length < n) {
            	n = arr.length;
            }
            
            DFS(0,0); //시작 위치, 교환 횟수
            
            System.out.println("#" + test_case + " " + max);
            
            max = 0;
		}
	}
    
    static void DFS(int start, int depth){
    	if(depth == n){
        	int result = 0;
            for(int i = 0; i < arr.length; i++){
            	result += (Math.pow(10, i) * arr[arr.length - i - 1]);
            }
            max = Math.max(max, result);
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
        	for(int j = i+1; j < arr.length; j++){
                    swap(i, j);
                    DFS(i, depth + 1);
                    swap(i, j);
            }
        }
    }
    
    static void swap(int i, int j){
    	int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}