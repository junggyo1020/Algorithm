import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int size = sizes.length;
        
        // 명함의 가로, 세로 길이를 저장
        int[] widths = new int[size];
        int[] heights = new int[size];
        
        for(int i = 0; i < size; i++){
            if(sizes[i][0] < sizes[i][1]){
                widths[i] = sizes[i][1];
                heights[i] = sizes[i][0];
            } else {
                widths[i] = sizes[i][0];
                heights[i] = sizes[i][1];
            }
        }
        
        // 명함의 가로 길이와 세로 길이를 각각 정렬(오름차순)
        Arrays.sort(widths);
        Arrays.sort(heights);
        
        // 가로, 세로 길이의 곱 리턴
        return (widths[sizes.length - 1] * heights[sizes.length - 1]);
    }
}