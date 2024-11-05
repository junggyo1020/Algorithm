import java.util.Scanner;

class Solution {
    
    private static boolean isValidate(int[] arr){
       	boolean[] check = new boolean[10];
    	for(int num : arr){
        	if(num < 1 || num > 9 || check[num]) return false;
            check[num] = true;
        }
        return true;
    }
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int[][] arr = new int[9][9];
            boolean isValid = true;
            for(int i = 0; i < 9; i++){
            	for(int j = 0; j < 9; j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            
            //행 검사
            for(int i = 0; i < 9; i++){
            	if(!isValidate(arr[i])){
                	isValid = false;
                    break;
                }
            }
            
            //열 검사
            if(isValid){
            	for(int i = 0; i < 9; i++){
                	int[] col = new int[9];
                    for(int j = 0; j < 9; j++){
                    	col[j] = arr[j][i];
                    }
                    if(!isValidate(col)){
                    	isValid = false;
                        break;
                    }
                }
            }
            
            //3x3 검사
            if(isValid){
                outerloop:
            	for(int i = 0; i < 9; i+=3){
                	for(int j = 0; j < 9; j+=3){
                    	int[] box = new int[9];
                        int index = 0;
                        for(int y = i; y < i+3; y++){
                        	for(int x = j; x < j+3; x++){
                            	box[index++] = arr[y][x];
                            }
                        }
                       	if(!isValidate(box)){
                        	isValid = false;
                            break outerloop;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, isValid ? 1:0);
		}
    }
}