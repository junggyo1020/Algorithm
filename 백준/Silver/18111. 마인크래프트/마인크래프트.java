import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, b;
    static int[][] map;
    static int minTime = Integer.MAX_VALUE;
    static int minHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //높이 0부터 256까지 작업이 걸리는 최소 시간을 구해보자.
        for(int h = 0; h <= 256; h++) {
            int time = calculate(h);
            if(minTime >= time) {
                minTime = time;
                minHeight = h;
            }
        }

        System.out.println(minTime + " " + minHeight);
    }

    // 땅 다듬기
    private static int calculate(int h) {
        int time = 0;
        int itemCnt = b;

        //1번 행동 해야함
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = map[i][j];
                if(map[i][j] <= h) continue;
                if(map[i][j] > h) {
                    itemCnt += map[i][j] - h; //인벤토리에 블록을 넣는다.
                    time += (map[i][j] - h) * 2; //각 작업시간 2초
                }
            }
        }

        //2번 행동 해야함
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] >= h) continue;
                if (map[i][j] < h) {
                    //채워야할 item수가 보유한 item 수보다 많은 경우
                    if(itemCnt < h - map[i][j]) return Integer.MAX_VALUE;
                    itemCnt -= h - map[i][j];
                    time += h - map[i][j];
                }
            }
        }
        return time;
    }
}
