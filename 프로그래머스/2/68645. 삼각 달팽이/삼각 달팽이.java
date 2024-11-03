class Solution {
    
    private static final int[] dx = {0,1,-1};
    private static final int[] dy = {1,0,-1};
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int x = 0;
        int y = 0;
        int v = 1;
        int d = 0;
        while(true){
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny==n||ny==-1||nx==n||nx==-1||triangle[ny][nx] != 0){
                d = (d+1)%3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(ny==n||ny==-1||nx==n||nx==-1||triangle[ny][nx] != 0){
                    break;
                }
            }
            x = nx;
            y = ny;
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