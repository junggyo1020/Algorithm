import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int h, w;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);
        grid = new int[h][w];

        // 지도 입력
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                char ch = str.charAt(j);
                if (ch == 'c') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (grid[i][j-1] == 0) {
                    for (int k = j; k < w; k++) {
                        if(grid[i][k] == 0) break;
                        grid[i][k] = grid[i][k-1] + 1;
                    }
                }
            }
        }
        
        // 디버깅
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
