import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * SW Expert Academy 5650. [모의 SW 역량테스트] 핀볼 게임
 * 메모리: 121,844 KB, 시간: 1,015 ms
 *
 * @author 서울_7반_정정교
 */
public class Solution {

	static int N;                  // 게임판의 크기 (N x N)
	static int answer;             // 최대 점수
	static int[][] map;            // 게임판 정보
	static HashMap<Point, Point> hM;  // 웜홀 쌍 (웜홀 입구 -> 출구)
	static ArrayList<Point>[] warmHole;  // 웜홀 번호별 위치 (인덱스 6~10 사용)

	// 상, 하, 좌, 우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());

			// 웜홀 정보를 저장할 리스트 초기화 (6~10번 웜홀)
			warmHole = new ArrayList[11];
			for (int i = 6; i <= 10; i++) {
				warmHole[i] = new ArrayList<>();
			}

			// 게임판 정보 입력
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 웜홀인 경우 warmHole 리스트에 추가
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						warmHole[map[i][j]].add(new Point(i, j));
					}
				}
			}

			// 웜홀 쌍을 해시맵에 저장 (서로 연결)
			hM = new HashMap<>();
			for(int i = 6; i <= 10; i++){
				// 웜홀이 쌍으로 있는 경우에만 처리
				if (warmHole[i].size() >= 2) {
					Point p1 = warmHole[i].get(0);
					Point p2 = warmHole[i].get(1);
					hM.put(p1, p2);
					hM.put(p2, p1);
				}
			}

			// 모든 빈 공간(0)에서 4방향으로 핀볼 게임 시작
			answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {  // 빈 공간인 경우에만 시작
						for (int d = 0; d < 4; d++) {
							simulation(i, j, d);
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	/**
	 * 핀볼 게임 시뮬레이션
	 * @param startY 현재 y좌표
	 * @param startX 현재 x좌표
	 * @param dir 현재 방향 (0:상, 1:하, 2:좌, 3:우)
	 */
	private static void simulation(int startY, int startX, int dir) {
		int score = 0;
		int y = startY;
		int x = startX;

		while (true) {
			y += dy[dir];
			x += dx[dir];

			// 1. 벽에 부딪힐 경우
			if (y < 0 || y >= N || x < 0 || x >= N) {
				score++;
				dir = changeDirection(5, dir); // 5번 블록과 동일한 로직
				continue;
			}

			// 2. 시작 위치로 돌아오거나 블랙홀을 만날 경우
			if ((y == startY && x == startX) || map[y][x] == -1) {
				answer = Math.max(answer, score);
				return;
			}

			// 3. 블록을 만날 경우 (1 ~ 5)
			if (map[y][x] >= 1 && map[y][x] <= 5) {
				score++;
				dir = changeDirection(map[y][x], dir);
				continue;
			}

			// 4. 웜홀을 만날 경우 (6 ~ 10)
			if (y >= 0 && y < N && x >= 0 && x < N && map[y][x] >= 6 && map[y][x] <= 10) {
				Point current = new Point(y, x);
				Point nextPos = hM.get(current);
				if (nextPos != null) {  // 웜홀 쌍이 있는 경우에만 이동
					y = nextPos.y;
					x = nextPos.x;
				}
			}
		}
	}

	/**
	 * 블록에 부딪혔을 때 방향을 변경
	 * @param block 블록 번호 (1 ~ 5)
	 * @param dir 현재 방향 (0:상, 1:하, 2:좌, 3:우)
	 * @return 변경된 방향
	 */
	private static int changeDirection(int block, int dir) {
		// dir: 0(상), 1(하), 2(좌), 3(우)
		int[][] change = {
				{}, // 0번 블록 (사용안함)
				{1, 3, 0, 2}, // 1번 블록
				{3, 0, 1, 2},
				{2, 0, 3, 1},
				{1, 2, 3, 0},
				{1, 0, 3, 2}  // 5번 블록
		};
		return change[block][dir];
	}

	private static class Point {
		int y, x;  // y: 행, x: 열

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;  // 같은 객체 참조인 경우
			if (o == null || getClass() != o.getClass()) return false;  // null이거나 다른 클래스인 경우
			Point point = (Point) o;
			return y == point.y && x == point.x;  // 좌표가 같은지 비교
		}

		@Override
		public int hashCode() {
			return 31 * y + x;
		}
	}
}
