import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {

    static int S;
    static boolean[][] visited;

    static class Node {
        int page, board, time;
        Node(int page, int board, int time) {
            this.page = page;
            this.board = board;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[1001][1001];

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1, 0, 0));
        visited[1][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.page == S) {
                System.out.println(cur.time);
                break;
            }

            //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if(!visited[cur.page][cur.page]) {
                visited[cur.page][cur.page] = true;
                q.offer(new Node(cur.page, cur.page, cur.time + 1));
            }

            //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if(cur.board > 0 && cur.page + cur.board <= 1000 && !visited[cur.page + cur.board][cur.board]) {
                visited[cur.page + cur.board][cur.board] = true;
                q.offer(new Node(cur.page + cur.board, cur.board, cur.time + 1));
            }

            //화면에 있는 이모티콘 중 하나를 삭제한다.
            if(cur.page > 0 && !visited[cur.page - 1][cur.board]) {
                visited[cur.page - 1][cur.board] = true;
                q.offer(new Node(cur.page - 1, cur.board, cur.time + 1));
            }
        }
    }
}