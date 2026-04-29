import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adj; //인접리스트
    static boolean[] visited; //방문체크용 배열
    
    private static void dfs(int start) {
        for(int x : adj[start]) {
            if(!visited[x]) {
                visited[x] = true;
                dfs(x);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0; //연결요소의 개수(= 네트워크 개수)
        
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    adj[i+1].add(j+1);
                }
            }
        }
        
        visited = new boolean[n+1];
        
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
}