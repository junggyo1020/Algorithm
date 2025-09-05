import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, X, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < K; i++) {
			//야바위를 수행
			st = new StringTokenizer(br.readLine());
			swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), arr);
		}
		
		for(int i = 1; i <= N; i++) {
			if(arr[i] == X) {
				System.out.println(i);
				return;
			}
		}
		
		return;
	}
	
	private static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
