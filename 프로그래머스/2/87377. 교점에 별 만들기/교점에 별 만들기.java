import java.util.*;

class Solution {
    
    private static class Point{
        private final long x, y;
        
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long a, long b, long e, long c, long d, long f){
        double x = (double)(b*f-e*d)/(a*d-b*c);
        double y = (double)(e*c-a*f)/(a*d-b*c);
        
        if(x %1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
    
    private Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(x < p.x) x = p.x; 
            if(y < p.y) y = p.y;
        }
        
        return new Point(x,y);
    }
    
    private Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(x > p.x) x = p.x; 
            if(y > p.y) y = p.y;
        }
        
        return new Point(x,y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                Point intersection = intersection(line[i][0], line[i][1], 
                                                  line[i][2], line[j][0], 
                                                  line[j][1], line[j][2]);
                
                if(intersection != null){
                    points.add(intersection);
                }
            }
        }
        
        Point maximum = getMaximumPoint(points);
        Point minimum = getMinimumPoint(points);
                
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