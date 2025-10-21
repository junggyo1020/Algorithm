import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, K;
	static String targetStr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		int[] initArr = new int[N];
		int[] targetArr = new int[N];

		for (int i = 0; i < N; i++) {
			initArr[i] = sc.nextInt();
			targetArr[i] = i + 1;
		}

		targetStr = arrToStr(targetArr);
		System.out.println(bfs(initArr));
	}

	public static int bfs(int[] initArr) {
		Queue<int[]> q = new LinkedList<>();
		Map<String, Integer> dist = new HashMap<>();

		q.offer(initArr);
		dist.put(arrToStr(initArr), 0);

		while (!q.isEmpty()) {
			int[] currArr = q.poll();
			String currStr = arrToStr(currArr);
			int currCost = dist.get(currStr);

			if (currStr.equals(targetStr)) {
				return currCost;
			}

			for (int i = 0; i <= N - K; i++) {
				int[] nextArr = reverse(currArr, i, K);
				String nextStr = arrToStr(nextArr);

				if (!dist.containsKey(nextStr)) {
					dist.put(nextStr, currCost + 1);
					q.offer(nextArr);
				}
			}
		}

		return -1;
	}

	public static String arrToStr(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		return sb.toString();
	}

	public static int[] reverse(int[] arr, int start, int k) {
		// 1. 배열 복사
		int[] newArr = Arrays.copyOf(arr, N);

		// 2. 뒤집을 구간 설정
		int left = start;
		int right = start + k - 1;

		// 3. 투 포인터로 뒤집기
		while (left < right) {
			int temp = newArr[left];
			newArr[left] = newArr[right];
			newArr[right] = temp;
			left++;
			right--;
		}

		return newArr;
	}
}