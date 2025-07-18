import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int N, Q, X, Y;
	static String cmd;
	static boolean[] isNotAvailable;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//방번호 최대 숫자 N과 업무의 수 Q 입력
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		//사용중인지 체크
		isNotAvailable = new boolean[N+1]; //1-based index
		
		//들어온 순서를 계산하기 위해 필드 추가
		HashMap<Integer, int[]> hM = new HashMap<>();
		int[] persons = new int[N+1];
		int cnt = 1; //할당된 순서
		
		//Q줄만큼 업무진행
		sb = new StringBuilder();
		for(int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			
			//명령어와 인원수 X와 평수 Y 입력
			cmd = st.nextToken();
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			//명령어별 역할 수행
			//new
			if(cmd.equals("new")) {
				boolean flag = false;
				for(int i = 1; i <= N - Y + 1; i++) {
					boolean cFlag = false;
					//Y개의 방이 모두 사용 가능한지 검사
					int j;
					for(j = 0; j < Y; j++) {
						//하나라도 사용불가능한 경우
						if(isNotAvailable[i+j]) {
							cFlag = true;
							break;
						}
					}
					//Y평 방이 사용가능한 경우
					if(!cFlag) {
						//왼쪽 방번호와 오른쪽 방번호 바로 출력
						int lr = i;
						int rr = i+Y-1;
						sb.append(lr).append(" ").append(rr).append('\n');
						flag = true;
						
						//방 할당하기
						for(int a = lr; a <= rr; a++) { 
							isNotAvailable[a] = true;
							persons[a] = X;
						}
						hM.put(cnt++, new int[] {lr, rr});
						break;
					}
				}
				if(!flag) sb.append("REJECTED").append('\n');
			}
			
			//in
			else if(cmd.equals("in")) {
				int[] cur = hM.get(X);
				for(int i = cur[0]; i <= cur[1]; i++) { 
					persons[i] += Y;
				}
			}
			
			//out
			else if(cmd.equals("out")) {
				int[] cur = hM.get(X);
				boolean flag = false;
				for(int i = cur[0]; i <= cur[1]; i++) { 
					persons[i] -= Y;
					if(persons[i] != 0) {
						flag = true;
					} else {
						isNotAvailable[i] = false;
					}
				}
				if(!flag) {
					sb.append("CLEAN").append(" ").append(cur[0]).append(" ").append(cur[1]).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}
