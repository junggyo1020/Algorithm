import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * D3_농작물 수확하기
 */
public class Solution {
    static int N, size;
    static int[][] farm;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1}; 
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int y, x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            //#1. 농작물 정보 입력받기
            N = Integer.parseInt(br.readLine());
            farm = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                String str = br.readLine();
                for(int j = 0; j < N; j++){
                    farm[i][j] = str.charAt(j) - '0';
                }
            }

            //#2. 출발 행, 열 구하기
            size = N/2;

            //#3. BFS 순회
            int answer = bfs(size, size);
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        visited[y][x] = true;
        int depth = 0;
        int sum = farm[y][x];
        while(!q.isEmpty()){
            int length = q.size();
            if(depth == size) break;
            
            for(int i = 0; i < length; i++){
                Node cur = q.poll();
                
                for(int d = 0; d < 4; d++){
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];

                    if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
                    q.offer(new Node(ny, nx));
                    sum += farm[ny][nx]; //농작물 가치 더하기
                    visited[ny][nx] = true;
                }
            }
            depth++;
        }

        return sum;
    }
}
