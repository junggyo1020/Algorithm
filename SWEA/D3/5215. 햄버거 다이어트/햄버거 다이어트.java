import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int N, L, maxScore;
	static int[] scores, cals;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		//#1. 테스트케이스 만큼 반복
		for(int t = 1; t <= T; t++) {
			//#2. 기본 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			scores = new int[N];
			cals = new int[N];
			isSelected = new boolean[N+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}
			
			//#3. 조합으로 모든 경우의 수 구하기
			maxScore = Integer.MIN_VALUE; //가장 맛에 대한 점수가 높은 햄버거 점수
			dfs(0, 0, 0);
			
			//#5. 결과 출력
			System.out.printf("#%d %d\n", t, maxScore);
		}
	}
	
	private static void dfs(int cnt, int sum, int cal) {
		//#4. 칼로리를 넘어서면 종료
		if(cal > L) {
			return;
		} 
		
		if(cnt == N) {
			maxScore = Math.max(maxScore, sum);
			return;
		}
		
		dfs(cnt+1, sum + scores[cnt], cal + cals[cnt]);
		dfs(cnt+1, sum, cal);
    }
}