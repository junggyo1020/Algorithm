import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int N, M;
    static int[][] compId;
    static int[] compSize;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
     
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        compId = new int[N][M];
        compSize = new int[N*M+1];
        int idx = 1;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && land[i][j] == 1) {
                    visited[i][j] = true;
                    compId[i][j] = idx;
                    compSize[idx] = bfs(i, j, land, idx);
                    idx++;
                }
            }
        }
        
        int answer = 0;
        for(int c = 0; c < M; c++) {
            Set<Integer> seen = new HashSet<>();
            int colSum = 0;
            for(int r = 0; r < N; r++) {
                if(land[r][c] == 1) {
                    int id = compId[r][c];
                    if(seen.add(id)) {
                        colSum += compSize[id];
                    }
                }
            }
            answer = Math.max(answer, colSum);
        }
        
        return answer;
    }
    
    private static int bfs(int r, int c, int[][] land, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        int size = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(!visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    compId[nr][nc] = idx;
                    size++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        return size;
    }
}