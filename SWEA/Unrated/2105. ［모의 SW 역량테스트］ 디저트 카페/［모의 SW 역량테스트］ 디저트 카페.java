import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] cafe;
	static boolean[] dessertVisited; // 디저트 종류(1~100)의 방문 여부 체크
	static int maxDesserts;
	static int startR, startC;

	// 방향: 우하, 좌하, 좌상, 우상 (시계방향)
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			maxDesserts = -1; // 최대 디저트 수 초기화

			// 모든 가능한 시작점에 대해 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					startR = i;
					startC = j;
					dessertVisited = new boolean[101]; // 디저트 종류는 1~100

					// 탐색 시작
					dessertVisited[cafe[i][j]] = true;
					dfs(i, j, 0, 1);
					// 시작점 방문 기록은 DFS 함수 진입 전에 하므로, 여기서 해제할 필요는 없음
				}
			}
			sb.append("#").append(t).append(" ").append(maxDesserts).append("\n");
		}
		System.out.print(sb);
	}

	/**
	 * @param r     현재 행
	 * @param c     현재 열
	 * @param dir   현재 방향 (0~3)
	 * @param count 현재까지 먹은 디저트 개수
	 */
	private static void dfs(int r, int c, int dir, int count) {
		// 현재 방향으로 직진하거나, 다음 방향으로 꺾는 2가지 경우 탐색
		for (int i = 0; i < 2; i++) {
			int ndir = dir + i; // i=0이면 직진, i=1이면 회전

			if (ndir > 3) continue; // 4번 이상 꺾을 수 없음

			int nr = r + dr[ndir];
			int nc = c + dc[ndir];

			// 1. 시작점으로 돌아온 경우
			if (nr == startR && nc == startC) {
				// 사각형을 그리며 돌아오려면 마지막 방향(3)이어야 함
				if (ndir == 3 && count > 2) {
					maxDesserts = Math.max(maxDesserts, count);
				}
				continue; // 시작점에 도달하면 어떤 경우든 탐색 종료
			}

			// 2. 범위를 벗어난 경우
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}

			// 3. 이미 먹은 디저트인 경우
			if (dessertVisited[cafe[nr][nc]]) {
				continue;
			}

			// 다음 경로로 탐색 진행
			dessertVisited[cafe[nr][nc]] = true;
			dfs(nr, nc, ndir, count + 1);
			dessertVisited[cafe[nr][nc]] = false; // 백트래킹
		}
	}
}