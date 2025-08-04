import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		//센서 정보 입력받기
		int[] sensor = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		
		//센서 정보 정렬하기
		Arrays.sort(sensor);
		
		//센서마다의 거리 계산해 저장하기
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < n-1; i++) {
			pq.offer(sensor[i+1] - sensor[i]);
		}
		
		for(int i = 0; i < k-1; i++) {
			pq.poll();
		}
		
		int sum = 0;
		while(!pq.isEmpty()) {
			sum += pq.poll();
		}
		
		System.out.println(sum);
	}
}
