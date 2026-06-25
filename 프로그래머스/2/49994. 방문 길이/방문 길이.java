class Solution {
    
    static boolean[][][] map;
    static int y, x, answer;
    static final int[] dy = {-1, 0, 0, 1}; //상좌우하
    static final int[] dx = {0, -1, 1, 0};
    
    public int solution(String dirs) {
        answer = 0;
        map = new boolean[11][11][4];
        y = 5; x = 5;
        
        for(char dir : dirs.toCharArray()) {
            if(dir == 'U') {
                move(0);
            } else if(dir == 'D') {
                move(3);
            } else if(dir == 'L') {
                move(1);
            } else {
                move(2);
            }
        }
        
        return answer;
    }
    
    private static void move(int d) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        
        if(ny >= 0 && ny < 11 && nx >= 0 && nx < 11) {
            if(!map[ny][nx][d]) {
                map[ny][nx][d] = true;
                map[y][x][3-d] = true;
                answer++;
            }
            y = ny;
            x = nx;
        }
    }
}