import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int count = 0;
            while(x <= n && y <= n){
            	if(x<y){
                	x += y;
                } else {
                	y += x;
                }
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb.toString());
	}
}