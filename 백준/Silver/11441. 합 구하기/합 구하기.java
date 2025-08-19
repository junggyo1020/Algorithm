import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] arr, pSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		pSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		//pSum[i] = 0부터 arr[i]까지의 합
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pSum[i+1] = pSum[i] + arr[i];
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int answer = pSum[y] - pSum[x-1];
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
