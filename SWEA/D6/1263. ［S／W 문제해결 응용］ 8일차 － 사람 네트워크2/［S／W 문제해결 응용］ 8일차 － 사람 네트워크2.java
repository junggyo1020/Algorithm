import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100000);
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int[][] dis = new int[1000][1000]; // 거리 정보

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
				int[] disK = dis[k];
				for(int i = 0; i < N; i++){          // 출
					if (i == k || dis[i][k] == INF) continue;
					int[] disI = dis[i];
					int disIK = dis[i][k];
					for(int j = 0; j < N; j++){      // 도
						int newDist = disIK + disK[j];
						if (newDist < disI[j]) {
							disI[j] = newDist;
						}
					}
				}
			}

			int minCC = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++){
				int sum = 0;
				int[] disI = dis[i];
				for(int j = 0; j < N; j++){
					sum += disI[j];
					if(sum >= minCC){
						sum = INF;
						break;
					}
				}
				if(minCC > sum){
					minCC = sum;
				}
			}

			sb.append("#").append(t).append(" ").append(minCC).append("\n");
		}

		System.out.print(sb);
	}
}