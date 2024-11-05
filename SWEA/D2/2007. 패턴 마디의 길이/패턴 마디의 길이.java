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
			String s = sc.next();
            boolean foundPattern = false;
            
            for(int i = 1; i <= 10; i++){ // 구간
                String pattern = s.substring(0,i);
                boolean isValid = true;
                
            	for(int j = i; j + i <= 30; j+=i){ 
                    if(!s.substring(j,j+i).equals(pattern)){
                    	isValid = false;
                        break;
                    }
                }
                
                if(isValid){
                	System.out.printf("#%d %d\n", test_case, i);
                    foundPattern = true;
                    break;
                }
            }
            if(!foundPattern){
            	System.out.printf("#%d -1\n", test_case);
            }
		}
        sc.close();
	}
}