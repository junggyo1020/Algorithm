import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dis = new int[N+1][N+1];
			for(int i = 1; i <= N; i++){
				for(int j = 1; j <= N; j++){
					int num = Integer.parseInt(st.nextToken());
					if(i==j) dis[i][j] = 0;
					else {
						dis[i][j] = num == 1 ? 1 : INF;
					}
				}
			}

			for(int k = 1; k <= N; k++){
				for(int i = 1; i <= N; i++){
					if(dis[i][k] == INF) continue; // i -> k로 가지 못하는 경우
					for(int j = 1; j <= N; j++){
						if(dis[k][j] == INF) continue; // j -> k로 가지 못하는 경우
						long sum = (long)dis[i][k] + dis[k][j];
						if(sum < dis[i][j]){
							dis[i][j] = (int)sum;
						}
					}
				}
			}

			int minSum = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++){
				int sum = 0;
				for(int j = 1; j <= N; j++){
					sum += dis[i][j];
				}
				minSum = Math.min(minSum, sum);
			}

			sb.append("#").append(t).append(" ").append(minSum).append("\n");
		}
		System.out.println(sb);
	}
}
