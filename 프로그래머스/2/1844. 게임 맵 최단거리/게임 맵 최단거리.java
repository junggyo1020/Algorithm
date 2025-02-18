import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dy = {-1,1,0,0}; //상하좌우
        int[] dx = {0,0,-1,1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny<0||ny>=n||nx<0||nx>=m||maps[ny][nx]!=1) continue;
                maps[ny][nx] = maps[y][x] + 1; //최단거리를 위한 거리계산
                q.offer(new int[]{ny, nx});
            }
        }
        
        return maps[n-1][m-1] > 1 ? maps[n-1][m-1] : -1;
        
    }
}