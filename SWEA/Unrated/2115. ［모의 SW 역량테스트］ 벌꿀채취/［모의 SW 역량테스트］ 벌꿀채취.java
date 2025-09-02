import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 벌꿀채취
 * 성능: 메모리 25,472kb 실행시간 83ms 코드길이 3,063
 * @author 서울_7반_정정교
 * 
 * 1. (1단계) 각 가능한 M개의 벌통 조합에서 얻을 수 있는 최대 이익을 미리 계산한다.
 * - M개의 벌통에서 꿀의 합이 C를 넘지 않는 모든 부분집합을 구해야 한다.
 * - 이는 DFS/백트래킹을 통해 효율적으로 탐색할 수 있다.
 * - 이 결과를 maxProfitMap 이라는 배열에 저장한다.
 *
 * 2. (2단계) 두 명의 일꾼이 겹치지 않게 벌통을 선택하여 최대 이익을 얻는 조합을 찾는다.
 * - 미리 계산된 maxProfitMap을 사용하여 모든 조합을 비교하고 최대값을 찾는다.
 */
public class Solution {

	static int N, M, C;
	static int[][] arr;
	static int[][] maxProfitMap;
	static int maxProfitPerOne;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			//1. 벌통정보 입력
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//2. 모든 좌표마다 최대 이익 구하기
			int totalMaxProfit = 0;
			maxProfitMap = new int[N][N-M+1];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-M+1; j++) {
					calculateProfit(i, j);	
				}
			}
			
			//3. 두명의 일꾼으로 전체 이익 갱신하기
			for(int i1 = 0; i1 < N; i1++) {
				for(int j1 = 0; j1 < N-M+1; j1++) {
					//같은 행에 존재하는 경우
					for(int j2 = j1+M; j2 < N-M+1; j2++) {
						totalMaxProfit = Math.max(totalMaxProfit, maxProfitMap[i1][j1] + maxProfitMap[i1][j2]);
					}
					
					//다른 행에 존재하는 경우
					for(int i2 = i1+1; i2 < N; i2++) {
						for(int j2 = 0; j2 < N-M+1; j2++) {
							totalMaxProfit = Math.max(totalMaxProfit, maxProfitMap[i1][j1] + maxProfitMap[i2][j2]);
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(totalMaxProfit).append("\n");
		}
		System.out.println(sb);
	}
	
	/**
	 * 시작 좌표에서 구할 수 있는 최대 수익 저장
	 * @param r
	 * @param c
	 */
	private static void calculateProfit(int r, int c) {
		//범위 내 모든 꿀 정보 저장
		int[] honey = new int[M];
		for(int i = 0; i < M; i++) {
			honey[i] = arr[r][c+i];
		}
		
		//최대 수익 정보 구하기
		maxProfitPerOne = 0;
		findMaxProfit(0, 0, 0, honey);
		maxProfitMap[r][c] = maxProfitPerOne;
	}
	
	/**
	 * 시작좌표에서 M범위까지 구할 수 있는 모든 경우의 수를 통해 최대 이익 구하기
	 * @param index
	 * @param honeySum
	 * @param profitSum
	 * @param honey
	 */
	private static void findMaxProfit(int index, int honeySum, int profitSum, int[] honey) {
		if(honeySum > C) return;
		
		maxProfitPerOne = Math.max(maxProfitPerOne, profitSum);
		
		if(index == M) return;
		
		findMaxProfit(index+1, honeySum+honey[index], profitSum+(honey[index]*honey[index]), honey);
		findMaxProfit(index+1, honeySum, profitSum, honey);
	}
}
