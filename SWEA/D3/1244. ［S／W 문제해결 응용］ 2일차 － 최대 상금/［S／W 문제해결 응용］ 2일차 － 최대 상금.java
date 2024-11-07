import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    
    static int maxPrize;
    static HashSet<String> visited;
    
    private static void findMaxPrize(char[] numbers, int swaps){
        if(swaps == 0){
    		int currentPrize = Integer.parseInt(new String(numbers));
        	maxPrize = Math.max(maxPrize, currentPrize);
            return;
        }
        
        int len = numbers.length;
        String currentState = new String(numbers) + swaps;
        if(visited.contains(currentState)) return;
        visited.add(currentState);
        
        for(int i = 0; i < len-1; i++){
        	for(int j = i+1; j < len; j++){
            	swap(numbers, i, j);
                findMaxPrize(numbers, swaps -1);
                swap(numbers, i, j);
            }
        }
        return;
    }
    
    private static void swap(char[] numbers, int i, int j){
    	char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String numStr = sc.next();
            int swaps = sc.nextInt();
            maxPrize = 0;
            visited = new HashSet<>();
            
            char[] numbers = numStr.toCharArray();
            findMaxPrize(numbers, swaps);
            
            System.out.printf("#%d %d\n", test_case, maxPrize);
		}
        sc.close();
	}
}