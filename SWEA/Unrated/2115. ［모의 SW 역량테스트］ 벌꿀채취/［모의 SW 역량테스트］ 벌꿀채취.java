import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 벌꿀채취
 * 성능: 
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

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, C;
	static int[][] map;
	static int[][] maxProfitMap;
	static int maxProfitPerWorker;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //벌통의 크기 <= 10
			M = Integer.parseInt(st.nextToken()); //벌통의 개수
			C = Integer.parseInt(st.nextToken()); //벌통 당 채취할 수 있는 꿀의 최대 양
			maxProfitPerWorker = Integer.MIN_VALUE;
			maxProfitMap = new int[N][N-M+1];
			//초기 벌통 정보 입력
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-M+1; j++) {
					calculateMaxProfit(i, j);
				}
			}
			
			int totalMaxProfit = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N-M+1; j++) {
					//같은 행에서 선택하는 경우
					for(int j2 = j+M; j2 < N-M+1; j2++) {
						totalMaxProfit = Math.max(totalMaxProfit, maxProfitMap[i][j] + maxProfitMap[i][j2]);
					}
					
					//다른 행에서 선택하는 경우
					for(int i2 = i+1; i2 < N; i2++) {
						for(int j2 = 0; j2 < N-M+1; j2++) {
							totalMaxProfit = Math.max(totalMaxProfit, maxProfitMap[i][j] + maxProfitMap[i2][j2]);
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(totalMaxProfit).append("\n");
		} //end TestCase
		System.out.println(sb);
	} //end Main
	
	private static void calculateMaxProfit(int r, int c) {
		int[] honey = new int[M];
		for(int i = 0; i < M; i++) {
			honey[i] = map[r][c+i];
		}
		
		maxProfitPerWorker = 0;
		findSubsetProfit(0, 0, 0, honey);
		maxProfitMap[r][c] = maxProfitPerWorker;
	}
	
	private static void findSubsetProfit(int index, int honeySum, int profitSum, int[] honey) {
		if(honeySum > C) return;
		
		maxProfitPerWorker = Math.max(maxProfitPerWorker, profitSum);
		
		if(index == M) {
			return;
		}
		
		findSubsetProfit(index+1, honeySum + honey[index], profitSum + honey[index]*honey[index], honey);
		findSubsetProfit(index+1, honeySum, profitSum, honey);
	}
}
