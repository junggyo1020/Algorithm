class Solution {
    public int[] solution(int n) {
        // 1. 2차원 배열 선언
        int[][] triangle = new int[n][n];
        int v = 1; // 삼각형에 채워넣을 숫자
        
        // 2. 숫자를 채울 현재 위치 (0,0)으로 설정
        int x = 0;
        int y = 0;
        
        // 3. 방향에 따라 이동할 수 없을 때 까지 반복하면서 숫자 채우기
        while(true){
            // 3-1. 아래로 이동
            while(true){
                triangle[y][x] = v++;
                if(y + 1 == n || triangle[y+1][x] != 0) break;
                y += 1;
            }
            if(x + 1 == n || triangle[y][x+1] != 0) break;
            x += 1;
            // 3-2. 오른쪽으로 이동
            while(true){
                triangle[y][x] = v++;
                if(x + 1 == n || triangle[y][x+1] != 0) break;
                x += 1;
            }
            if(triangle[y-1][x-1] != 0) break;
            x -= 1;
            y -= 1;
            // 3-3. 왼쪽 위로 이동
            while(true){
                triangle[y][x] = v++;
                if(triangle[y-1][x-1] != 0) break;
                x -= 1;
                y -= 1;
            }
            if(y + 1 == n || triangle[y+1][x] != 0) break;
            y += 1;
        }
        int[] result = new int[v-1];
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                result[idx++] = triangle[i][j];
            }
        }
        
        return result;
    }
}