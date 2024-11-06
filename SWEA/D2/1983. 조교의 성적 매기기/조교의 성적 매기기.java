import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
    private static final String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int k = sc.nextInt() -1; // 0-index
            double[] totalScore = new double[n];
            double targetScore = 0;
            
            for(int i = 0; i < n; i++){
            	double midScore = sc.nextDouble();
                double finalScore = sc.nextDouble();
                double assignmentScore = sc.nextDouble();
                
                totalScore[i] = midScore * 0.35 + finalScore * 0.45 + assignmentScore * 0.20;
                if(i==k){
                	targetScore = totalScore[i];
                }
            }
            
            Double[] sortedScore = Arrays.stream(totalScore).boxed().toArray(Double[]::new);
            Arrays.sort(sortedScore, Collections.reverseOrder());
            
            int rank = Arrays.asList(sortedScore).indexOf(targetScore);
            int gradeIdx = (rank * 10) / n;
            
            System.out.printf("#%d %s\n", test_case, grade[gradeIdx]);
		}
	}
}