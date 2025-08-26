import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S/W 문제해결 응용] 최적 경로
 * @author 서울_7반_정정교
 *
 * 냉장고 배달 -> N명의 고객을 방문하고 -> 집에 돌아가야 함
 * 회사에서 출발하여 N명의 고객을 모두 방문하고 집에 돌아오는 경로 중 가장 짧은 이동거리를 찾아야 한다.
 * 
 * N: 고객의 수  (<=10)
 * y, x: 좌표 (<=100)
 * 
 * 시간제한이 여유로워서 일단 완전탐색을 생각하자.
 * 
 */
public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, minDistance; //고객의 수, 최단거리
	static Point[] points; //좌표 저장
	static boolean[] visited;
	
	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		points = new Point[N+2];
		minDistance = Integer.MAX_VALUE;
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		//회사
		points[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		//집
		points[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i = 0; i < N; i++) {
			points[i+2] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
	
	private static void solve() {
		dfs(0,0,0);
		sb.append(minDistance).append("\n");
	}
	
	/**
	 * 외판원 순회
	 * @param pos 현재 위치
	 * @param cnt 방문한 Point 개수
	 * @param dist 현재까지의 거리
	 */
	private static void dfs(int pos, int cnt, int dist) {
		if(dist >= minDistance) return;
		if(cnt == N) {
			int dis = getDistance(points[pos], points[1]);
			minDistance = Math.min(dis + dist, minDistance);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int next = i+2;
				int disNext = getDistance(points[pos], points[next]);
				dfs(next, cnt+1, dist + disNext);
				visited[i] = false;
			}
		}
	}
	
	/**
	 * 맨헤튼 거리 구하는 함수
	 * @param o1
	 * @param o2
	 * @return |x1-x2| + |y1-y2|
	 */
	private static int getDistance(Point o1, Point o2) {
		return Math.abs(o1.x - o2.x) + Math.abs(o1.y - o2.y);
	}
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			input();
			solve();
		}
		System.out.println(sb);
	}

}
