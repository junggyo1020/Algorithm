import java.io.*;
import java.util.*;
class Solution
{
    private static boolean isPalindrome(String s){
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

			StringBuilder[] colArr = new StringBuilder[100]; // 열마다 문자열을 저장하는 배열
            for(int i = 0; i < 100; i++){
            	colArr[i] = new StringBuilder();
            }
            
            int max = 0; // 팰린드롬의 최장길이
            for(int i = 0; i < 100; i++){
            	String rowStr = br.readLine();
                for(int j = 0; j < 100; j++){ //열 배열 정보도 저장
                	colArr[j].append(rowStr.charAt(j));
                }
                
                check: for(int len = 100; len > max; len--){
                                for(int start = 0; start <= 100 - len; start++){
                                    String rowSubstring = rowStr.substring(start, start + len);
                                    if(isPalindrome(rowSubstring)){
                                        max = len;
                                        break check;
                                    }
                                }
               	 			}
            }
            
            //열 검사
            for(int i = 0; i < 100; i++){
            	String colStr = colArr[i].toString();
                
                check: for(int len = 100; len > max; len--){
                                for(int start = 0; start <= 100 - len; start++){
                                    String colSubstring = colStr.substring(start, start + len);
                                    if(isPalindrome(colSubstring)){
                                        max = len;
                                        break check;
                                    }
                                }
                			}
            }
            
            System.out.printf("#%d %d\n", t, max);
		}
	}
}