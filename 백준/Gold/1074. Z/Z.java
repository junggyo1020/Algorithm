import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c;
    static int time;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int)Math.pow(2, n);
        dfs(0, 0, size);
    }

    private static void dfs(int y, int x, int size) {
        if(size == 1) {
            System.out.println(time);
            System.exit(0);
        }

        int newSize = size / 2;
        int quadrantSize = newSize * newSize;

        if(r < y + newSize && c < x + newSize) { //1사분면
            dfs(y, x, newSize);
        } else if(r < y + newSize && c >= x + newSize) { //2사분면
            time += quadrantSize;
            dfs(y, x + newSize, newSize);
        } else if(r >= y + newSize && c < x + newSize) { //3사분면
            time += quadrantSize * 2;
            dfs(y + newSize, x, newSize);
        } else { //4사분면
            time += quadrantSize * 3;
            dfs(y + newSize, x + newSize, newSize);
        }
    }
}
