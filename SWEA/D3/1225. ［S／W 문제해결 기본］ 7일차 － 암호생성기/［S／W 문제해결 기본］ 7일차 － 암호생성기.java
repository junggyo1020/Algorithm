import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
    static Queue<Integer> q;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
            q = new LinkedList<>();
            
            for(int i = 0; i < 8; i++){
            	q.offer(sc.nextInt());
            }
            
            int count = 1;
            while(true){
            	int front = q.poll() - count;
                
                if(front <= 0){
                	q.offer(0);
                    break;
                }
                
                q.offer(front);
                count++;
                
                if(count > 5){
                	count = 1;
                }
            }
           	System.out.printf("#%d ", test_case);
           	for(int i = 0; i < 8; i++){
            	System.out.print(q.poll() + " ");
            }
            System.out.println();
		}
        sc.close();
	}
}