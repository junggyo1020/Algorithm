import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;
    static StringTokenizer st;
    static final int SIZE = 32768;
    static List<Point> list;
    static boolean[] visited;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for(int i = 0; i < N+2; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) + SIZE;
                int c = Integer.parseInt(st.nextToken()) + SIZE;
                list.add(new Point(r, c));
            }

            Point start = list.get(0);
            Point end = list.get(N+1);
            visited = new boolean[N+2];

            Queue<Point> q = new ArrayDeque<>();
            q.offer(start);
            visited[0] = true;
            boolean success = false;

            while(!q.isEmpty()) {
                Point cur = q.poll();

                //바로 도착지 까지 도착가능한지 확인
                if(Math.abs(cur.r - end.r) + Math.abs(cur.c - end.c) <= 1000) {
                    success = true;
                    break;
                }

                //근처 방문할 수 있는 편의점이 있는지 확인
                for(int i = 1; i < N+1; i++) {
                    if(Math.abs(cur.r - list.get(i).r) + Math.abs(cur.c - list.get(i).c) <= 1000) {
                        if(!visited[i]) {
                            q.offer(new Point(list.get(i).r, list.get(i).c));
                            visited[i] = true;
                        }
                    }
                }
            }

            System.out.println(success ? "happy" : "sad");
        }
    }
}