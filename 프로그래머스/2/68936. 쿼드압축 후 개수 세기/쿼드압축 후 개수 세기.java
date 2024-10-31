class Solution {
    
    private static class Count{
        public final int zero;
        public final int one;
        
        Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
        
        public Count add(Count other){
            return new Count(zero + other.zero, one + other.one);
        } 
    }
    
    private Count count(int offsetX, int offsetY, int size, int[][] arr){
        int h = size / 2;
        
        // 주어진 영역에서 모든 숫자가 같지 않은 경우
        for(int x = offsetX; x < offsetX + size; x++){
            for(int y = offsetY; y < offsetY + size; y++){
                if(arr[y][x] != arr[offsetY][offsetX]){
                    // 재귀 함수 구현
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        
        // 주어진 영역의 모든 숫자가 같은 경우
        if(arr[offsetY][offsetX] == 1){
            return new Count(0,1);
        }
        return new Count(1,0);
    }
    
    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
    }
}