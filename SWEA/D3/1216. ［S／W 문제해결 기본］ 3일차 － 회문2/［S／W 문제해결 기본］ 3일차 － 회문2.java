import java.util.*;
import java.io.*;
class Solution
{
    static char[][] wordBoard;
    
    private static boolean isPalindrome(String s){
    	//회문인지 검사
		for(int i = 0; i < s.length() / 2; i++){
        	if(s.charAt(i) != s.charAt(s.length() - i - 1)){
            	return false;
            }
        }
        return true;
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int t = Integer.parseInt(br.readLine());
            StringBuilder[] colArr = new StringBuilder[100];
            //null로 초기화 될 경우 문자열을 추가할 수 없다.
            for(int i = 0; i < 100; i++){
            	colArr[i] = new StringBuilder();
            }
            
            int max = 0;
            // 행 검사
            for(int i = 0; i < 100; i++){
            	String inputLine = br.readLine();
                for(int j = 0; j < 100; j++){
                	colArr[j].append(inputLine.charAt(j));
                }
                
                check: for(int len = 100; len > max; len--){
                	for(int start = 0; start <= 100 - len; start++){
                    	String rowSubstring = inputLine.substring(start, start+len);
                        if(isPalindrome(rowSubstring)){
                        	max = len;
                            break check;
                        }
                    }
                }
            }
            
            for(int i = 0; i < 100; i++){
            	String colLine = colArr[i].toString();
                check: for(int len = 100; len > max; len--){
                	for(int start = 0; start <= 100 - len; start++){
                    	String colSubstring = colLine.substring(start, start + len);
                        if(isPalindrome(colSubstring)){
                        	max = Math.max(max, len);
                            break check;
                        }
                    }
                }
            }
                           
           System.out.printf("#%d %d\n", t, max);
		}
	}
}