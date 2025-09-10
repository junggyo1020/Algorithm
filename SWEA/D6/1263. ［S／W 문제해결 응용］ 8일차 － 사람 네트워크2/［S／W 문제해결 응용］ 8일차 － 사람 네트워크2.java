import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int[][] dis = new int[N][N]; // 거리 정보

			// 인접 행렬 입력 & 초기 거리 설정
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					int num = Integer.parseInt(st.nextToken());
					if(i == j) {
						dis[i][j] = 0;  // 자기 자신으로의 거리는 0
					} else {
						// 연결되어 있으면 거리 1, 아니면 INF로 설정
						dis[i][j] = num == 1 ? 1 : INF;
					}
				}
			}

			// 플로이드-워셜
			for(int k = 0; k < N; k++){ 		     // 경
				for(int i = 0; i < N; i++){          // 출
					for(int j = 0; j < N; j++){      // 도
						// i->k, k->j 경로가 모두 존재하는 경우
						if (dis[i][k] != INF && dis[k][j] != INF) {
							int newDist = dis[i][k] + dis[k][j];
							if (newDist < dis[i][j]) {
								dis[i][j] = newDist;
							}
						}
					}
				}
			}

			int minCC = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++){
				int sum = 0;
				for(int j = 0; j < N; j++){
					sum += dis[i][j];
				}
				minCC = Math.min(minCC, sum);
			}

			sb.append("#").append(t).append(" ").append(minCC).append("\n");
		}

		System.out.print(sb);
	}
}