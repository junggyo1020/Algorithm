
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
        	if(!Character.isAlphabetic(c)){
            	sb.append(c);
            } else {
            	sb.append(Character.toUpperCase(c));
            }
        }
        
        System.out.println(sb.toString());
	}
}