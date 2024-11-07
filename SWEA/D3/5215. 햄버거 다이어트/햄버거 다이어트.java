import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int n, calorieLimit;
    static int[] tasteScores;
    static int[] calories;
    static int maxTasteScore;
    
    private static void dfs(int index, int currentTaste, int currentCalorie){
    	if(currentCalorie > calorieLimit) return;
        maxTasteScore = Math.max(currentTaste, maxTasteScore);
        if(index == n) return;
        //해당 재료 포함안하는 경우
        dfs(index + 1, currentTaste, currentCalorie);
        //해당 재료 포함하는 경우
        dfs(index + 1, currentTaste + tasteScores[index], currentCalorie + calories[index]);
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = sc.nextInt();
            calorieLimit = sc.nextInt();
            tasteScores = new int[n];
            calories = new int[n];
            
            for(int i = 0; i < n; i++){
            	tasteScores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }
            
            maxTasteScore = 0;
            dfs(0,0,0);
            
            System.out.printf("#%d %d\n", test_case, maxTasteScore);
		}
	}
}