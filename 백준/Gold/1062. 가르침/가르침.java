import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] wordMasks; // 각 단어를 비트마스크로 변환하여 저장
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 필수 문자 5개(a, n, t, i, c)보다 K가 작으면 어떤 단어도 읽을 수 없음
		if (K < 5) {
			System.out.println(0);
			return;
		} else if (K == 26) {
			System.out.println(N);
			return;
		}

		wordMasks = new int[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int mask = 0;
			for (char c : str.toCharArray()) {
				mask |= (1 << (c - 'a')); // 각 문자를 비트로 변환하여 합침
			}
			wordMasks[i] = mask;
		}

		// 기본적으로 배워야 하는 5개 문자 미리 설정
		int baseMask = 0;
		baseMask |= (1 << ('a' - 'a'));
		baseMask |= (1 << ('c' - 'a'));
		baseMask |= (1 << ('i' - 'a'));
		baseMask |= (1 << ('n' - 'a'));
		baseMask |= (1 << ('t' - 'a'));

		// DFS 시작: 'a'부터 순회하며 K-5개를 더 선택
		dfs(0, 5, baseMask);

		System.out.println(answer);
	}

	/**
	 * @param start 탐색을 시작할 알파벳 인덱스 (0~25)
	 * @param count 현재까지 배운 단어 수
	 * @param mask  현재까지 배운 단어들의 비트마스크
	 */
	private static void dfs(int start, int count, int mask) {
		// K개의 단어를 모두 배운 경우
		if (count == K) {
			int canReadCount = 0;
			for (int wordMask : wordMasks) {
				// (단어비트 & 배운비트) == 단어비트 이면 해당 단어의 모든 글자를 배운 것
				if ((wordMask & mask) == wordMask) {
					canReadCount++;
				}
			}
			answer = Math.max(answer, canReadCount);
			return;
		}

		for (int i = start; i < 26; i++) {
			// 아직 배우지 않은 알파벳인 경우만 선택
			if ((mask & (1 << i)) == 0) {
				dfs(i + 1, count + 1, mask | (1 << i));
			}
		}
	}
}