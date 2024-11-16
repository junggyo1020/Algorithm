import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
        	StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++){
                sb = new StringBuilder();
            	boolean isFlag = false;
                
                String s = String.valueOf(i);
                for(char c : s.toCharArray()){
                	if(c == '3' || c == '6' || c == '9'){
                    	sb.append("-");
                        isFlag = true;
                    }
                }
                if(!isFlag){
                	System.out.printf("%s ", s);
                } else {
                	System.out.printf("%s ", sb.toString());
                }
            }
	}
}