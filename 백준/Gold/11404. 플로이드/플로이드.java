import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringTokenizer st;
	static int[][] dist;
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N][N];

		//1. 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dist[i][j] = (i==j) ? 0 : INF;
			}
		}

		//2. 간선 정보 입력
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			dist[u][v] = Math.min(dist[u][v], w);
		}

		//3. 플로이드 워셜
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		//4. 결과 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dist[i][j] != INF) {
					sb.append(dist[i][j]).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
