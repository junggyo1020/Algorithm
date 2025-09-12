import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// 빠른 입력을 위해 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strLen = str.length();

		// 'a'의 총 개수를 세어서 윈도우의 크기 정하기
		int aCount = 0;
		for (char c : str.toCharArray()) {
			if (c == 'a') {
				aCount++;
			}
		}

		// 만약 'a'가 없다면 교환할 필요가 없으므로 0을 출력하고 종료!
		if (aCount == 0) {
			System.out.println(0);
			return;
		}

		// 첫 번째 윈도우(인덱스 0 ~ aCount-1) 'b' 개수 계산
		int bCount = 0;
		for (int i = 0; i < aCount; i++) {
			if (str.charAt(i) == 'b') {
				bCount++;
			}
		}

		int minSwaps = bCount;

		for (int i = 1; i < strLen; i++) {

			// 윈도우에서 빠지는 문자 (맨 왼쪽)
			char removingChar = str.charAt(i - 1);
			if (removingChar == 'b') {
				bCount--; // 'b'가 빠졌으므로 개수 감소
			}

			// 윈도우에 새로 들어오는 문자 (맨 오른쪽)
			// 원형으로 순환하는 인덱스를 계산
			int addingIndex = (i + aCount - 1) % strLen;
			char addingChar = str.charAt(addingIndex);
			if (addingChar == 'b') {
				bCount++; // 'b'가 들어왔으므로 개수 증가
			}

			// 현재 윈도우의 'b' 개수와 최소값을 비교 후 갱신
			minSwaps = Math.min(minSwaps, bCount);
		}

		System.out.println(minSwaps);
	}
}
