import java.util.Scanner;

public class Main {

    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(printQuadTree(0,0,n));
    }

    public static String printQuadTree(int x, int y, int size){
        if (isAllSame(x, y, size)) {
            return Integer.toString(grid[y][x]);
        }

        StringBuilder result = new StringBuilder();
        result.append("(");
        result.append(printQuadTree(x, y, size / 2));
        result.append(printQuadTree(x + size / 2, y, size / 2));
        result.append(printQuadTree(x, y + size / 2, size / 2));
        result.append(printQuadTree(x + size / 2, y + size / 2, size / 2));
        result.append(")");
        return result.toString();
    }

    public static boolean isAllSame(int x, int y, int size){
        int temp = grid[y][x];
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(grid[i][j] != temp){
                    return false;
                }
            }
        }
        return true;
    }
}
