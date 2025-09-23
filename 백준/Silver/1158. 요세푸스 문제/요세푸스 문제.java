import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		while(dq.size()>=1) {
			for(int i = 0; i < K-1; i++) {
				dq.offer(dq.poll());
			}
			answer.add(dq.poll());
		}
		
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(answer.get(0));
		for(int i = 1; i < answer.size(); i++) {
			sb.append(", ").append(answer.get(i));
		}
		sb.append(">");
        System.out.println(sb);
	}
}
