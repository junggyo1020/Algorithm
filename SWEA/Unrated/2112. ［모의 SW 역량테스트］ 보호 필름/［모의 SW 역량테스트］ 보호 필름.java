import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, min;
	static int[][] film;
	static int[] selected; // 각 행을 A(0), B(1), 변경X(-1)로 처리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 두께
			W = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준

			film = new int[D][W];
			selected = new int[D];
			Arrays.fill(selected, -1); // -1: 변경X, 0: A, 1: B

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	// 행을 선택하는 모든 경우의 수를 탐색 (백트래킹)
	private static void dfs(int row, int cnt) {
		// 현재까지의 변경 횟수가 최소값을 넘어가면 더 이상 탐색할 필요 없음
		if (cnt >= min) return;

		// 모든 행을 다 확인했으면 성능 검사
		if (row == D) {
			if (check()) {
				min = Math.min(min, cnt);
			}
			return;
		}

		// 1. 현재 행을 변경하지 않는 경우
		selected[row] = -1;
		dfs(row + 1, cnt);

		// 2. 현재 행을 A(0)로 변경
		selected[row] = 0;
		dfs(row + 1, cnt + 1);

		// 3. 현재 행을 B(1)로 변경
		selected[row] = 1;
		dfs(row + 1, cnt + 1);
	}

	// 성능 검사
	private static boolean check() {
		for (int j = 0; j < W; j++) {
			boolean valid = false;
			int count = 1;

			for (int i = 1; i < D; i++) {
				// 현재 셀의 값 (변경된 경우 selected 값, 아니면 원래 값)
				int prev = selected[i-1] == -1 ? film[i-1][j] : selected[i-1];
				int curr = selected[i] == -1 ? film[i][j] : selected[i];

				if (prev == curr) {
					count++;
					if (count >= K) {
						valid = true;
						break;
					}
				} else {
					count = 1;
				}
			}

			// K가 1인 경우는 count가 1이어도 통과
			if (K == 1) {
				valid = true;
			}

			if (!valid) return false;
		}
		return true;
	}
}