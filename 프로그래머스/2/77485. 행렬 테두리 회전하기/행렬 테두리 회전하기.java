import java.util.*;

class Solution {
    
    static int[][] map;
    static List<Integer> list;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        map = new int[rows][columns];
        int cnt = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = cnt++;
            }
        }
        
        for(int[] query : queries) {
            list = new ArrayList<>();
            
            int y1 = query[0] - 1;
            int x1 = query[1] - 1;
            int y2 = query[2] - 1;
            int x2 = query[3] - 1;
            
            for(int c1 = x1; c1 < x2; c1++) list.add(map[y1][c1]);
            for(int r1 = y1; r1 < y2; r1++) list.add(map[r1][x2]);
            for(int c2 = x2; c2 > x1; c2--) list.add(map[y2][c2]);
            for(int r2 = y2; r2 > y1; r2--) list.add(map[r2][x1]);
            
            //회전하기
            rotate(y1, x1, y2, x2);   
            
            //값들 중 최솟값 넣기
            answer[idx++] = Collections.min(list);
        }
        
        return answer;
    }
    
    private static void rotate(int y1, int x1, int y2, int x2) {
        int tmp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        list.addFirst(tmp);
        
        int idx = 0;
        for(int c1 = x1; c1 < x2; c1++) map[y1][c1] = list.get(idx++);
        for(int r1 = y1; r1 < y2; r1++) map[r1][x2] = list.get(idx++);
        for(int c2 = x2; c2 > x1; c2--) map[y2][c2] = list.get(idx++);
        for(int r2 = y2; r2 > y1; r2--) map[r2][x1] = list.get(idx++);
    }
}