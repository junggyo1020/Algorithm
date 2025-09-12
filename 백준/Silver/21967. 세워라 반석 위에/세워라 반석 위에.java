import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * N의 길이 1백만
 * 연속한 부분 수열 중 가장 긴 수열의 길이 구하기
 * 부분 수열?(배열) -> 투포인터
 *
 * 단순한 아이디어
 * - 부분수열을 구한다. -> 투포인터 O(N) = 최대 1백만 -> 가능!
 * - 최대값, 최소값을 갱신한다.
 * - 최대 & 최소의 차를 계산한다.
 * - 차가 2이하라면, 해당 길이를 갱신한다.
 * - 결과 출력하기
 *  gogo
 *
 *  결론: 계속해서 최대 최소값을 갱신해 주어야 하기 때문에, 양쪽 끝을 모두 사용할 수 있는
 *  TreeMap을 사용하는 것이 이 문제의 핵심인 듯 하다.
 */
public class Main {

	static int N;
	static int[] stone;
	static TreeMap<Integer, Integer> tM;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stone = new int[N];
		tM = new TreeMap<>();

		//1. 반석 정보 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
		}

		//2. 투포인터
		int res = 0; //가장 긴 반석의 길이
		int s = 0; //시작 포인터

		// //이렇게하면 범위가 줄어들때는 최대 최소 갱신이 안됨
		// for (int e = 0; e < N; e++) {
		// 	maxN = Math.max(maxN, stone[e]);
		// 	minN = Math.min(minN, stone[e]);
		// 	if (Math.abs(maxN - minN) <= 2) {
		// 		res = Math.max(res, e - s + 1);
		// 	} else { //여기에 갱신해야함
		// 		minN = Integer.MAX_VALUE;
		// 		s++;
		// 		//시간초과날텐데????!?!?
		// 		//넣으면 자동으로 갱신되게 하자!!! -> TreeMap
		// 		for(int k = s; k < e; k++){
		// 			minN = Math.min(minN, stone[k]);
		// 		}
		// 	}
		// }

		for (int e = 0; e < N; e++) {
			tM.put(stone[e], tM.getOrDefault(stone[e], 0) + 1);

			//최대값 - 최소값이 <= 2일 때까지 범위 줄이기
			while (tM.lastKey() - tM.firstKey() > 2) {
				tM.put(stone[s], tM.get(stone[s]) - 1); //가장 작은 수 줄이기
				if (tM.get(stone[s]) == 0) {
					tM.remove(stone[s]);
				}
				s++;
			}

			res = Math.max(res,  e - s + 1);
		}

		System.out.println(res);
	}
}
