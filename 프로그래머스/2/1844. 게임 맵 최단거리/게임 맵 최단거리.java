import java.util.*;

class Solution {
    
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx] != -1 || maps[ny][nx] == 0) continue;
                
                visited[ny][nx] = visited[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }
        
        return visited[n-1][m-1];
    }
}