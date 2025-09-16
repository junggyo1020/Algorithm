import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N, M;
	static char[][] map;
	static ArrayList<Point> cars = new ArrayList<>();
	static ArrayList<Point> parks = new ArrayList<>();
	static int[][] dist; // dist[i][j]: i번째 차가 j번째 주차장에 가는 최단 시간
	static ArrayList<Integer>[] adj; // 이분 매칭 그래프
	static int[] match; // match[j]: j번째 주차장을 차지한 차의 인덱스
	static boolean[] visited; // dfs용 방문 배열

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'C') {
					cars.add(new Point(i, j));
				} else if (map[i][j] == 'P') {
					parks.add(new Point(i, j));
				}
			}
		}

		N = cars.size();
		M = parks.size();

		if (N == 0) {
			System.out.println(0);
			return;
		}
		if (N > M) {
			System.out.println(-1);
			return;
		}

		// 1. 모든 차 <-> 모든 주차장 거리 계산 (BFS)
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1); // 도달 불가능은 -1
			bfs(i, cars.get(i));
		}

		// 2. 이분 탐색
		int low = 0;
		int high = R * C + 1; // 최대 시간
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (canMatch(mid)) {
				ans = mid; // mid 시간으로 가능. 더 짧은 시간 탐색
				high = mid - 1;
			} else {
				low = mid + 1; // mid 시간으로 불가능. 더 긴 시간 탐색
			}
		}
		System.out.println(ans);
	}

	// i번째 차에서 모든 주차장까지의 거리 계산
	static void bfs(int carIdx, Point start) {
		Queue<Point> q = new LinkedList<>();
		int[][] time = new int[R][C];
		for(int i=0; i<R; i++) Arrays.fill(time[i], -1);

		q.offer(start);
		time[start.y][start.x] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 'X' || time[ny][nx] != -1) {
					continue;
				}

				time[ny][nx] = time[cur.y][cur.x] + 1;
				q.offer(new Point(ny, nx));
			}
		}

		// BFS 종료 후, 주차장까지의 거리 저장
		for (int j = 0; j < M; j++) {
			dist[carIdx][j] = time[parks.get(j).y][parks.get(j).x];
		}
	}

	// 시간(maxTime)이 주어졌을 때, 모든 차가 주차 가능한지 확인하자! (이분 매칭)
	static boolean canMatch(int maxTime) {
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

		// maxTime 이내로 도달 가능한 차-주차장 간선 연결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dist[i][j] != -1 && dist[i][j] <= maxTime) {
					adj[i].add(j);
				}
			}
		}

		match = new int[M];
		Arrays.fill(match, -1);
		int count = 0;

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			if (dfs(i)) {
				count++;
			}
		}
		return count == N;
	}

	// 이분 매칭 DFS
	static boolean dfs(int carIdx) {
		if (visited[carIdx]) return false;
		visited[carIdx] = true;

		for (int parkIdx : adj[carIdx]) {
			// parkIdx가 아직 매칭되지 않았거나,
			// (match[parkIdx])가 이미 매칭됐지만, 그 차가 다른 곳으로 이동 가능할 때
			if (match[parkIdx] == -1 || dfs(match[parkIdx])) {
				match[parkIdx] = carIdx; // 이 주차장은 carIdx가 차지한다!
				return true;
			}
		}
		return false;
	}
}