import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[][] board;
    static ArrayList<Point> list;

    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        list = new ArrayList<>();

        //빈칸 입력
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        dfs(list, 0);
    }

    private static void dfs(ArrayList<Point> arr, int idx) {
        if(idx == list.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        for(int i = 1; i < 10; i++) {
            if(checkRow(arr, idx, i) && checkCol(arr, idx, i) && checkBox(arr, idx, i)) {
                board[arr.get(idx).y][arr.get(idx).x] = i;
                dfs(arr, idx+1);
            }

            if(i == 9) {
                board[arr.get(idx).y][arr.get(idx).x] = 0;
            }
        }
    }

    private static boolean checkRow(ArrayList<Point> arr, int idx, int pos) {
        for(int i = 0; i < 9; i++) {
            if(arr.get(idx).x == i) continue;
            if(board[arr.get(idx).y][i] == pos) return false;
        }
        return true;
    }

    private static boolean checkCol(ArrayList<Point> arr, int idx, int pos) {
        for(int i = 0; i < 9; i++) {
            if(arr.get(idx).y == i) continue;
            if(board[i][arr.get(idx).x] == pos) return false;
        }
        return true;
    }

    private static boolean checkBox(ArrayList<Point> arr, int idx, int pos) {
        int a = arr.get(idx).y/3;
        int b = arr.get(idx).x/3;

        a*=3;
        b*=3;

        for(int i = a; i < a+3; i++) {
            for(int j = b; j < b+3; j++) {
                if(arr.get(idx).y == i && arr.get(idx).x == j) continue;
                if(board[i][j] != 0 && board[i][j] == pos) return false;
            }
        }
        return true;
    }
}
