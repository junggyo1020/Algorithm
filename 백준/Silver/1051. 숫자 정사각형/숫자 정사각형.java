import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //#1 배열 저장
        int[][] square = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                square[i][j] = s.charAt(j) - '0';
            }
        }

        int max_len = Math.min(n, m);
        for(int len = max_len; len >= 1; len--){
            for(int r = 0; r < n - len + 1; r++){
                for(int c = 0; c < m - len + 1; c++){
                    int top_left = square[r][c];
                    int top_right = square[r][c + len - 1];
                    int bottom_left= square[r + len - 1][c];
                    int bottom_right = square[r + len - 1][c + len - 1];

                    if(top_left == top_right && top_left == bottom_left && top_left == bottom_right){
                        System.out.println(len*len);
                        return;
                    }
                }
            }
        }

    }
}
