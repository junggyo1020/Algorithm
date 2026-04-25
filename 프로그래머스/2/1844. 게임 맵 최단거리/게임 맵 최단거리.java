import java.util.*;

class Solution {
    
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    static int[][] visited;
    
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        visited = new int[N][M];
        
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(maps[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[cur.r][cur.c] + 1;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        
        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < M; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return visited[N-1][M-1] == 0 ? -1 : visited[N-1][M-1];
    }
}