import java.util.*;

class Solution {
    
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        //선언부
        int[] answer = new int[5];
        
        //구현부
        for(int k = 0; k < 5; k++) {
            char[][] room = new char[5][5]; //대기실
            List<int[]> start = new ArrayList<>(); //P좌표
            answer[k] = 1;
            for(int i = 0; i < 5; i++) {
                String place = places[k][i];
                for(int j = 0; j < 5; j++) {
                    room[i][j] = place.charAt(j);
                    //P인 좌표를 모두 저장한다.
                    if(room[i][j] == 'P') start.add(new int[]{i, j});
                }
            }
            //좌표를 시작점으로 BFS를 진행한다.
            //P를 찾거나 범위를 넘어갈때까지 진행
            //P를 찾았는데, visited[y][x] + 1 <= 2 이면 0 반환
            //루프를 모두 돌면 1반환
            outerLoop:
            for(int i = 0; i < start.size(); i++) {
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{start.get(i)[0], start.get(i)[1]});
                int[][] visited = new int[5][5];
                for(int r = 0; r < 5; r++) {
                    Arrays.fill(visited[r], -1);
                }
                visited[start.get(i)[0]][start.get(i)[1]] = 0;
                
                innerLoop:
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int y = cur[0];
                    int x = cur[1];
                    
                    for(int d = 0; d < 4 ; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];
                        
                        if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                        if(room[ny][nx] == 'P' && visited[ny][nx] == -1) {
                            if(visited[y][x] + 1 <= 2) {
                                answer[k] = 0;
                                break outerLoop;
                            }
                            break innerLoop;
                        }
                        
                        if(room[ny][nx] == 'O' && visited[ny][nx] == -1) {
                            q.offer(new int[]{ny, nx});
                            visited[ny][nx] = visited[y][x] + 1;
                        }
                    }
                }
            }
        }
        
        
        
        return answer;
    }
}