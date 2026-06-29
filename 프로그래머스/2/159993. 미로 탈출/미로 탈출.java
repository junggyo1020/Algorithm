import java.util.*;

class Solution {
    
    static char[][] grid;
    static int[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N, M, sy, sx, answer;
    static boolean isPulled;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        grid = new char[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        answer = -1;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                char ch = maps[i].charAt(j);
                if(ch == 'S') {
                    sy = i;
                    sx = j;
                }
                grid[i][j] = ch;
            }
        }
        
        //레버까지 최단거리 찾기
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        visited[sy][sx] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            if(grid[y][x] == 'L') {
                isPulled = true;
                int dist = visited[y][x];
                for(int i = 0; i < N; i++) {
                    Arrays.fill(visited[i], -1);
                }
                visited[y][x] = dist;
                sy = y;
                sx = x;
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] != -1 || grid[ny][nx] == 'X') continue;
                
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
        
        //출구까지 가기!
        q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            
            if(grid[y][x] == 'E') return visited[y][x];
            
            for(int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] != -1 || grid[ny][nx] == 'X') continue;
                
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }
        
        return answer;
    }
}