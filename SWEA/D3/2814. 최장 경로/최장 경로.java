import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int n, m;
    static int longestLength;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    private static void dfs(int node, int pathLength){
    	visited[node] = true;
        longestLength = Math.max(longestLength, pathLength);
        
        for(int v : graph[node]){
        	if(!visited[v]){
            	dfs(v, pathLength + 1);
            }
        }
        
        visited[node] = false; // 백트래킹
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            m = sc.nextInt();
            graph = new ArrayList[n+1];
            
            for(int i = 0; i < n+1; i++){
            	graph[i] = new ArrayList<>();
            }
            
            for(int i= 0 ; i < m; i++){
            	int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x].add(y);
                graph[y].add(x);
            }
            
            longestLength = 0;
            visited = new boolean[n+1];
            
            for(int i = 1; i <= n; i++){
            	dfs(i,1);
            }
            
            System.out.printf("#%d %d\n", test_case, longestLength);
		}
        sc.close();
	}
}