import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			switch(cmd) {
				case 1:
					int x = Integer.parseInt(st.nextToken());
					stack.push(x);
					break;
				case 2:
					if (!stack.isEmpty()) {
						sb.append(stack.pop());
					} else {
						sb.append(-1);
					}
					sb.append("\n");
					break;
				case 3:
					sb.append(stack.size());
					sb.append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty() ? 1 : 0);
					sb.append("\n");
					break;
				case 5:
					sb.append(stack.isEmpty() ? -1 : stack.peek());
					sb.append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}
