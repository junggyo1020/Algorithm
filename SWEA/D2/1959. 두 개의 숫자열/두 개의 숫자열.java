import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author: SSAFY
 * @date: 2025. 7. 18.
 * @link:https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AZewY0EKsb3HBIN_&contestProbId=AV5PpoFaAS4DFAUq&probBoxId=AZfDwgOq3cLHBISV&type=PROBLEM&problemBoxTitle=%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98+Track%28%EB%82%9C%EC%9D%B4%EB%8F%84+%EC%A4%91%29&problemBoxCnt=3
 * @performance:
 * @category:투포인터, 누적합
 * @note:
 */
public class Solution {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] arrN, arrM;
	static int mSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			mSum = Integer.MIN_VALUE;
			
			//배열 N 입력
			arrN = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arrN[i] = Integer.parseInt(st.nextToken());
			}
			
			//배열 M 입력
			arrM = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}
			
			//배열 A의 길이가 긴 경우
			if(N < M) {
				int[] tmp = arrN;
				arrN = arrM;
				arrM = tmp;
				
				int tmp2 = N;
				N = M;
				M = tmp2;
			}
			
			for(int rt = 0; rt < N - M + 1; rt++) {
				int sum = 0; //곱한 합
				for(int k = 0; k < M; k++) {
					//배열의 합 구하기
					sum += arrN[rt+k] * arrM[k];
				}
				mSum = Math.max(mSum, sum);
			}
			sb.append("#").append(t).append(" ").append(mSum).append('\n');
		}
		System.out.println(sb);
	}

}
