import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};

	static class Cell implements Comparable<Cell> {
		int y, x;
		int life;
		int time;
		boolean isActive;

		public Cell(int x, int y, int time, int life, boolean isActive) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.life = life;
			this.isActive = isActive;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.life, this.life);
		}
	}

	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Cell> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[700][700];
			visited = new boolean[700][700];
			pq = new PriorityQueue<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int y = i + 350;
					int x = j + 350;
					map[y][x] = Integer.parseInt(st.nextToken());
					if (map[y][x] > 0) {
						pq.add(new Cell(x, y, 0, map[y][x], false));
						visited[y][x] = true;
					}
				}
			}

			sb.append("#").append(t).append(" ").append(simulate()).append("\n");
		} //end testcase
		System.out.println(sb);
	}// end main

	private static int simulate() {
		// 살아있는 세포를 관리하는 기본 큐
		Queue<Cell> livingCells = new LinkedList<>();
		// 초기 세포들을 pq에서 livingCells로 이동
		while(!pq.isEmpty()) {
			livingCells.add(pq.poll());
		}

		for (int time = 1; time <= K; time++) {
			// 이번 시간에 번식해서 태어날 후보들을 관리 (생명력 높은 순)
			PriorityQueue<Cell> newCandidates = new PriorityQueue<>();
			// 다음 시간까지 살아남을 세포들을 임시 저장
			Queue<Cell> nextGeneration = new LinkedList<>();

			// 1. 현재 살아있는 모든 세포의 상태를 업데이트하고 번식 후보를 찾는다.
			int currentSize = livingCells.size();
			for (int i = 0; i < currentSize; i++) {
				Cell cur = livingCells.poll();

				// 비활성 상태 로직
				if (!cur.isActive) {
					cur.time++;
					if (cur.time == cur.life) {
						cur.isActive = true;
						cur.time = 0; // 활성 시간 카운트를 위해 초기화
					}
					nextGeneration.add(cur); // 다음 시간에도 살아있음
				}
				// 활성 상태 로직
				else {
					// 활성화된 첫 시간에만 번식
					if (cur.time == 0) {
						for (int d = 0; d < 4; d++) {
							int nx = cur.x + dx[d];
							int ny = cur.y + dy[d];

							if (!visited[ny][nx]) {
								// 아직 visited를 true로 만들지 않고 후보군에만 추가
								newCandidates.add(new Cell(nx, ny, 0, cur.life, false));
							}
						}
					}

					cur.time++;
					// 활성 상태로 life 시간만큼 살았으면 죽음
					if (cur.time < cur.life) {
						nextGeneration.add(cur);
					}
				}
			}

			// 2. 번식 후보들 중에서 최종 승자를 결정하고, livingCells에 추가한다.
			while (!newCandidates.isEmpty()) {
				Cell winner = newCandidates.poll();

				// 아직 아무도 차지하지 않은 땅이라면 승자가 차지한다.
				if (!visited[winner.y][winner.x]) {
					visited[winner.y][winner.x] = true;
					nextGeneration.add(winner);
				}
			}

			// 3. 다음 세대로 교체
			livingCells = nextGeneration;
		}

		return livingCells.size();
	}
}
