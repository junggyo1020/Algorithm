import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static Point[] worms;
	static int N;
	static long res;
	static int sumY, sumX;
	static int totalY, totalX;

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			res = Long.MAX_VALUE;
			totalX = totalY = 0;
			
			//#1. 지렁이의 좌표 정보 입력
			worms = new Point[N];
			for (int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				worms[i] = new Point(x, y);
				totalX += x;
				totalY += y;
			}

			//#2. 지렁이의 소개팅 주선하기
			//그냥 순열로 풀면 최대 20!으로 당연히 시간초과다..
			//출발하는 그룹과 도착지의 그룹 2가지가 있으니, 해당 부분으로 활용할 수 없을까?
			//20마리 지렁이중, 움직일 10마리를 뽑으면?
			dfs(0, 0, 0, 0);

			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int start, int cnt, long curX, long curY) {
		if(cnt == N/2) {
			long finalX = totalX - 2*curX;
			long finalY = totalY - 2*curY;

			res = Math.min(res, finalX*finalX + finalY*finalY);
			return;
		}

		if(start == N) return;

		dfs(start + 1, cnt + 1, curX + worms[start].x, curY + worms[start].y);
		dfs(start + 1, cnt, curX, curY);
	}
}
