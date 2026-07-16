class Solution {
    public int[] solution(int n) {
        int size = n*(n+1)/2;
        int[] answer = new int[size];
        int[][] grid = new int[n][n];
        
        if(n == 1) return new int[]{1};
        
        int idx = 1;
        int dir = 0;
        int y = 0, x = 0;
        grid[0][0] = 1;
        while(idx < size) {
            if(dir == 0) {
                while(y+1 < n && grid[y+1][x] == 0) {
                    y++;
                    grid[y][x] = ++idx;
                }
            }
            else if(dir == 1) {
                while(x+1 < n && grid[y][x+1] == 0) {
                    x++;
                    grid[y][x] = ++idx;
                }
            } else  {
                while(y-1 >= 0 && x-1 >= 0 && grid[y-1][x-1] == 0) {
                    y--; x--;
                    grid[y][x] = ++idx;
                }
            }
            dir = (dir + 1) % 3;
        }
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = grid[i][j];
            }
        }
        
        return answer;
    }
}