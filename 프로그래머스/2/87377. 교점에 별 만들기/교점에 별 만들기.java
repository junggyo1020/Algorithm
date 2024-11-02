import java.util.*;

class Solution {
    
    private static class Point{
        public final long x;
        public final long y;
        
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long A, long B, long E, long C, long D, long F){
        double x = (double)((B*F) - (E*D)) / ((A*D) - (B*C));
        double y = (double)((E*C) - (A*F)) / ((A*D) - (B*C));
        
        // 정수로만 표현되는 좌표만 입력하기
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
    
    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                  line[j][0], line[j][1], line[j][2]);
                
                // 교점이 있을 경우 리스트에 저장
                if(intersection != null){
                    points.add(intersection);
                }
            }
        }
        
        // minimum과 maximum 포인트를 찾기
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        
        int width = (int)(maximum.x - minimum.x + 1);
        int height = (int)(maximum.y - minimum.y + 1);
        
        char[][] arr = new char[height][width];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        
        for(Point p : points){
            int x = (int)(p.x - minimum.x);
            int y = (int)(maximum.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
        
        return result;
    }
}
