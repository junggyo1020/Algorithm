import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Main {

    static char[][] map;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static ArrayList<Point> list;
    static int count, answer;

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        visited = new boolean[12][6];

        //지도 정보 입력
        for(int i = 0; i < 12; i++) {
            String str = br.readLine();
            for(int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //터트릴 수 있는 뿌요가 있는지 확인
        while(true) {
            boolean canExplode = false;
            visited = new boolean[12][6];

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(map[i][j] != '.' && !visited[i][j]) {
                        if(checkAndExplode(i, j)) {
                            canExplode = true;
                        }
                    }
                }
            }

            //더이상 터트릴 수 없는 경우
            if(!canExplode) break;

            //재배치
            reload();
            answer++;
        }

        System.out.println(answer);
    }

    private static boolean checkAndExplode(int y, int x) {
        ArrayList<Point> list = new ArrayList<>();
        Queue<Point> q = new ArrayDeque<>();
        char color = map[y][x];

        q.offer(new Point(y, x));
        list.add(new Point(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny<0||nx<0||ny>=12||nx>=6) continue;
                if(!visited[ny][nx] && map[ny][nx] == color) {
                    q.offer(new Point(ny, nx));
                    visited[ny][nx] = true;
                    list.add(new Point(ny, nx));
                }
            }
        }

        //같은 색이 4번 이상 존재하면
        if(list.size() >= 4) {
            for(Point p : list) {
                map[p.y][p.x] = '.';
            }
            return true;
        }

        return false;
    }

    private static void reload() {
        for(int c = 0; c < 6; c++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for(int r = 0; r < 12; r++) {
                if(map[r][c] != '.') {
                    stack.push(map[r][c]);
                    map[r][c] = '.';
                }
            }

            //재배치
            int idx = 11;
            while(!stack.isEmpty()) {
                map[idx--][c] = stack.pop();
            }
        }
    }
}