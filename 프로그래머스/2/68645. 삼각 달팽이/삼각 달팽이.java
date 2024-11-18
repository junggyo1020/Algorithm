class Solution {
    
    private static final int[] dy = {1, 0, -1};
    private static final int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = 0, y = 0;
        int d = 0;
        int v = 1;
        
        while(true){
            arr[y][x] = v++;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0){
                d = (d + 1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0){
                    break;
                }
            }
            y = ny;
            x = nx;
        }
        
        int index = 0;
        int[] result = new int[v-1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                result[index++] = arr[i][j];
            }
        }
        return result;
    }
}