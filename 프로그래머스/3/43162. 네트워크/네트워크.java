import java.util.*;

class Solution {
    
    static List<Integer>[] list;
    static boolean[] visited;
    
    private static void dfs(int[][] computers, int pos) {
        for(int x : list[pos]) {
            if(!visited[x]) {
                visited[x] = true;
                dfs(computers, x);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int N = computers.length;
        visited = new boolean[n];
        
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(computers, i);
            }
        }
        
        return answer;
    }
}