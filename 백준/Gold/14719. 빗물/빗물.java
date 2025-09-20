import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] heights = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int totalRain = 0;

		// 첫 번째 칸과 마지막 칸은 물이 고일 수 없으므로 i는 1부터 W-1까지 순회
		for (int i = 1; i < W - 1; i++) {
			// 현재 위치를 기준으로 왼쪽에서 가장 높은 블록 찾기
			int leftMax = 0;
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, heights[j]);
			}

			// 현재 위치를 기준으로 오른쪽에서 가장 높은 블록 찾기
			int rightMax = 0;
			for (int j = i + 1; j < W; j++) {
				rightMax = Math.max(rightMax, heights[j]);
			}

			// 둘 중 더 낮은 블록의 높이를 기준으로 물 높이 결정
			int waterLevel = Math.min(leftMax, rightMax);

			// 물 높이가 현재 블록 높이보다 높을 때만 빗물이 고임
			if (waterLevel > heights[i]) {
				totalRain += waterLevel - heights[i];
			}
		}

		System.out.println(totalRain);
	}
}
