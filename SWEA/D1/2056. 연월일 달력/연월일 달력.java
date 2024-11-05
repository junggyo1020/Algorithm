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
            boolean result = true;
            int y = Integer.parseInt(s.substring(0,4));
            int m = Integer.parseInt(s.substring(4,6));
            int d = Integer.parseInt(s.substring(6,8));
            //유효성 검사
            if(1>m || 12<m){
            	result = false;
            } else {
            	switch(m){
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        if(d<1 || d>31){
                        	result = false;
                            break;
                        }
                        break;
                    case 2:
                        if(d<1 || d > 28){
                        	result = false;
                            break;
                        }
                        break;
                    case 4: case 6: case 9: case 11:
                        if(d<1 || d >30){
                        	result = false;
                            break;
                        }
                        break;
                	}
                }
            	if(result){
            		System.out.printf("#%d %04d/%02d/%02d\n", test_case, y, m, d);
                } else {
                	System.out.printf("#%d -1\n", test_case);
                }
            }
	}
}