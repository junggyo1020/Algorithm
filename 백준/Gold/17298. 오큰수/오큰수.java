import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 오큰수 구하기
 * 오큰수 : 어떤 수보다 크고 오른쪽에 있는 수들 중 가장 왼쪽에 있는 수
 * 범위 : n 1백만 , 시간 : 1초
 * -> 무식하게 구할 수 있는지? (완전탐색)
 * -> 일단 시도해보자 (1백만 * 1백만 = 대충 1000억)
 * -> 다른 방법 이용해야 함
 * -> 짝짓기 문제 = 스택으로 풀어보자
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n]; // 숫자 카드를 담을 배열
		int[] result = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(result, -1);

		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			// 새로 온 친구가 대기줄 맨 앞 친구보다 클 동안 계속 반복
			while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
				result[stack.pop()] = a[i];
			}
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int res : result) {
			sb.append(res).append(" ");
		}
		System.out.println(sb);
	}
}
