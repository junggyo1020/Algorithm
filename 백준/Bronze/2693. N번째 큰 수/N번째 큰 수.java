import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static final int SIZE = 10;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[SIZE];
			for(int i = 0; i < SIZE; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			//정렬
			Arrays.sort(arr);

			//N번째 큰수
			//예시 : 4번째로 큰 수 1 2 3 4 5 -> arr[SIZE - 4];
			sb.append(arr[SIZE - 3]).append("\n");
		}
		System.out.println(sb);
	}
}
