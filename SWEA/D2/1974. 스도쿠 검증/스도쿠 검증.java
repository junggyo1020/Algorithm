import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	static int[][] arr;
    
    private static boolean isValidate(int[] arr){
        boolean[] isCheck = new boolean[10];
    	for(int num : arr){
        	if(num < 1 || num >9 || isCheck[num]) return false;
            isCheck[num] = true;
        }
        return true;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			boolean isValid = true;
			arr = new int[9][9];
			for(int i=0; i < 9; i++) {
				for(int j=0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//가로 탐색
			for(int i=0; i < 9; i++){
            	if(!isValidate(arr[i])){
                	isValid = false;
                    break;
                }
            }
			
			//세로 탐색
			if(isValid){
                for(int i=0; i < 9; i++){
                    int[] col = new int[9];
                    for(int j=0; j < 9; j++){
                        col[j] = arr[j][i];
                    }
                    if(!isValidate(col)){
                        isValid = false;
                        break;
                    }
                }
            }
			
			//3x3 탐색
			if(isValid){
                outerLoop:
            	for(int i = 0; i < 9; i+=3){
                	for(int j = 0; j < 9; j+=3){
                    	int[] box = new int[9];
                        int index = 0;
                        for(int k = i; k < i + 3; k++){
                        	for(int l = j; l < j + 3; l++){
                           		box[index++] = arr[k][l];
                            }
                        }
                        if(!isValidate(box)){
                        	isValid = false;
                            break outerLoop;
                        }
                    }
                }   
            }
			
			if(isValid) {
				System.out.printf("#%d %d\n", test_case, 1);
			} else {
				System.out.printf("#%d %d\n", test_case, 0);
			}
		}
		sc.close();
	}
}