import java.util.Scanner;

class Solution {
    
    private static int getMaxIdx(int[] arr){
    	int maxIdx = 0;
        for(int i = 1; i < arr.length; i++){
        	if(arr[i] > arr[maxIdx]) maxIdx = i;
        }
        return maxIdx;
    }
    
    private static int getMinIdx(int[] arr){
    	int minIdx = 0;
        for(int i = 1; i < arr.length; i++){
        	if(arr[i] < arr[minIdx]) minIdx = i;
        }
        return minIdx;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = 10;  // 문제에서 총 10개의 테스트 케이스가 주어짐
        for (int test_case = 1; test_case <= T; test_case++) {
        	int dumpLimit = sc.nextInt();
            int width = 100;
            int[] heights = new int[width];
            
            for(int i = 0; i < width; i++){
            	heights[i] = sc.nextInt();
            }
            
            for(int i = 0; i < dumpLimit; i++){
            	int maxIdx = getMaxIdx(heights);
                int minIdx = getMinIdx(heights);
                
                // 종료조건
                if(heights[maxIdx] - heights[minIdx] <= 1) break;
                
                heights[maxIdx]--;
                heights[minIdx]++;                
            }
        	int maxHeights = heights[getMaxIdx(heights)];
            int minHeights = heights[getMinIdx(heights)];
            int result = maxHeights - minHeights;
            System.out.printf("#%d %d\n", test_case, result);
        }
        sc.close();
    }
}
