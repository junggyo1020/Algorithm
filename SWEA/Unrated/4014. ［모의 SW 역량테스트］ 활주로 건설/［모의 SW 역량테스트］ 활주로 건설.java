import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 활주로 건설
 * 성능: 
 * @author 서울_7반_정정교
 *
 */
public class Solution {

	static int N, X;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            int[][] mapRotated = new int[N][N]; // 열 검사를 위해 90도 회전

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    mapRotated[j][i] = map[i][j];
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (canBuild(map[i])) count++;       // 행 검사
                if (canBuild(mapRotated[i])) count++; // 열 검사
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean canBuild(int[] line) {
        boolean[] isCheck = new boolean[N];

        for (int i = 1; i < N; i++) {
            int diff = line[i] - line[i-1];

            if (Math.abs(diff) > 1) return false; // 높이 차 2 이상이면 즉시 실패
            if (diff == 0) continue; // 높이 같으면 통과

            if (diff == 1) { // 올라가는 경사로
                for (int j = i - X; j < i; j++) {
                    if (j < 0 || isCheck[j] || line[j] != line[i-1]) return false;
                }
                for (int j = i - X; j < i; j++) isCheck[j] = true;
            } else { // 내려가는 경사로 (diff == -1)
                for (int j = i; j < i + X; j++) {
                    if (j >= N || isCheck[j] || line[j] != line[i]) return false;
                }
                for (int j = i; j < i + X; j++) isCheck[j] = true;
            }
        }
        return true;
    }
}
