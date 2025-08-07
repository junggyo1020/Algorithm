import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, answer;
	static ArrayList<Integer>[] list;
	static boolean[] isInvited;
	
	public static void main(String[] args) throws IOException {
		//#1. 초기설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		isInvited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		//#2. 간선 입력 
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a); //무방향그래프
		}
		
		//#3. 상근이(1)의 친구 구하기
		bfs(1); //시작 노드
		
		//#5 결과 출력
		System.out.println(answer);
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		isInvited[1] = true;
		int depth = 0;
		
		while(!q.isEmpty()) {
			if(depth >= 2) break;
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int cur = q.poll(); //현재 사람
				//#4 관계된 사람 고름
				for(int next : list[cur]) {
					//#4-1 이미 초대한 사람이 아닌경우
					if(!isInvited[next]) {
						q.offer(next);
						++answer; //초대 가능한 인원 추가
						isInvited[next] = true;
//						System.out.println("초대된 인원 : " + next);
					}
				}
			}
			depth++;
		}
	}
}
