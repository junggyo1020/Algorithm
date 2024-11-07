/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    
    private static boolean isPalindrome(String s){
    	for(int i = 0; i < s.length() / 2; i++){
        	if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int count = 0;
			int wordLength = sc.nextInt();
            char[][] arr = new char[8][8];
            for(int i = 0; i < 8; i++){
                String line = sc.next();
            	for(int j = 0; j < 8; j++){
                	arr[i][j] = line.charAt(j);
                }
            }
            
            // 행 검사
            for(int row = 0; row < 8; row++){
                for(int i = 0; i < 8 - wordLength + 1; i++){
                    StringBuilder sb = new StringBuilder();
                	for(int j = i; j < i + wordLength; j++){
                    	sb.append(arr[row][j]);
                    }
                    if(isPalindrome(sb.toString())){
                    	count++;
                    }
                }
            }
            
            // 열 검사
            for(int col = 0; col < 8; col++){
                for(int i = 0; i < 8 - wordLength + 1; i++){
            		StringBuilder sb2 = new StringBuilder();
                	for(int j = i; j < i + wordLength; j++){
                    	sb2.append(arr[j][col]);
                    }
                    if(isPalindrome(sb2.toString())){
                    	count++;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, count);
		}
	}
}