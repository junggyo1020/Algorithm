import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;
    // 방향 벡터: 오른쪽 위, 오른쪽, 오른쪽 아래
    static int[] dr = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 0번 행부터 순서대로 파이프 놓기 시도
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean dfs(int r, int c) {
        // 현재 위치를 방문 처리 (파이프 설치)
        map[r][c] = 'x';

        // 마지막 열에 도달했다면 성공
        if (c == C - 1) {
            return true;
        }

        // 세 방향 탐색 (오른쪽 위 -> 오른쪽 -> 오른쪽 아래)
        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + 1;

            // 맵 범위 체크 및 방문 가능 여부 체크
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (map[nr][nc] == '.') {
                    // 다음 경로에서 성공했다면, 즉시 true를 반환하며 종료
                    if (dfs(nr, nc)) {
                        return true;
                    }
                }
            }
        }

        // 세 방향 모두 실패했다면, 이 경로는 답이 될 수 없음
        return false;
    }
}