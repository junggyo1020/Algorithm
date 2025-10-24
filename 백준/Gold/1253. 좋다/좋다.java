import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numbers;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		for(int k = 0; k < N; k++) {
			int target = numbers[k];
			int lt = 0;
			int rt = N - 1;
			while(lt < rt) {
				long sum = (long)numbers[lt] + numbers[rt];
				if(sum == target) {
					if(lt == k) lt++;
					else if(rt == k) rt--;
					else {
						answer++;
						break;
					}
				} else if(sum < target) {
					lt++;
				} else {
					rt--;
				}
			}
		}

		System.out.println(answer);
	}
}
