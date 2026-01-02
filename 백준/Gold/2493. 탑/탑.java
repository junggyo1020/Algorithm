import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N; // 최대 50만
	static int[] arr, result; // 최대 1억
	static ArrayDeque<Node> stack;

	static class Node {
		int val, idx;
		Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		result = new int[N+1];
		stack = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= N; i++) {
			int num = arr[i];

			//스택이 비었거나 더 큰 수를 찾을 때까지 반복
			while(!stack.isEmpty() && stack.peek().val < num) {
				stack.pop();
			}

			//만약 스택이 비었다면
			if(stack.isEmpty()) {
				result[i] = 0;
			} else {
				//더 큰 수를 찾은 경우
				Node node = stack.peek();
				int cIdx = node.idx;

				//현재 탑은 현재 스택에 남아있는 가장 높은 탑으로 송신한다.
				result[i] = cIdx;
			}

			//스택에 push
			stack.push(new Node(num, i));
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
