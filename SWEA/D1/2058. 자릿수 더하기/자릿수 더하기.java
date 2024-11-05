import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
			String s = sc.next();
            int sum = 0;
            for(char c : s.toCharArray()){
            	sum += (int)(c - '0');
            }
            System.out.println(sum);
	}
}