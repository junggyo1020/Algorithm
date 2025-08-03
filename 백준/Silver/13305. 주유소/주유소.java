import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] dis = new long[N-1];
		long[] cost = new long[N];
		for(int i = 0; i < N-1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long totalCost = 0;
		long minSum = cost[0];
		
		for(int i = 0; i < N-1; i++) {
			if(minSum > cost[i]) {
				minSum = cost[i];
			}
			totalCost += minSum * dis[i];
		}
		System.out.println(totalCost);
	}
}
