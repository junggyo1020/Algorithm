import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 특이한 자석
 * 성능: 
 * @author 서울_7반_정정교
 *
 */
public class Solution {

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int K, sum; //자석을 회전시키는 횟수, 획득한 점수
	static ArrayList<Integer>[] list; //4개의 자석을 저장하는 list
	static int[] rotateInfo;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int T = Integer.parseInt(br.readLine());
		 for(int t=1; t<=T; t++) {
			 K=Integer.parseInt(br.readLine());//자석을 회전시키는 횟수
			 sum = 0;
			 
			 //#1. 자석정보 입력2
			 list = new ArrayList[5];
			 for(int i=1; i<=4; i++) {
				 list[i] = new ArrayList<>();
			 }
			 
			 for(int i=1; i<=4; i++) { //자석의 종류(1-4)
				 st = new StringTokenizer(br.readLine());
				 for(int j=0; j<8; j++) { //자석의 날은 8개(0-7)
					 list[i].add(Integer.parseInt(st.nextToken()));
				 }
			 }
			 
			 //#2. 회전정보 입력
			 for(int k=0; k<K; k++) {
				 st = new StringTokenizer(br.readLine());
				 int magnetNum = Integer.parseInt(st.nextToken());
				 int dir = Integer.parseInt(st.nextToken());
				 
				 //#3. 회전해야할 정보 저장하기
				 rotateInfo = new int[5];
				 rotateInfo[magnetNum] = dir; 
				 for (int i = magnetNum; i > 1; i--) {
				     if (list[i].get(6) != list[i - 1].get(2)) {
				         rotateInfo[i - 1] = -rotateInfo[i];
				     } else {
				         break; 
				     }
				 }

				 for (int i = magnetNum; i < 4; i++) {
				     if (list[i].get(2) != list[i + 1].get(6)) {
				         rotateInfo[i + 1] = -rotateInfo[i];
				     } else {
				         break;
				     }
				 }
				 
				 //#4. 회전하기
				 for(int r = 1; r <= 4; r++) {
					 rotate(r, rotateInfo[r]);
				 }
				 
			 } //end forLoop
			 
			//#6. 점수 획득하기
			 for(int j=1; j<=4; j++) {
				 sum += list[j].get(0) * (1<<(j-1));
			 }
			 
			 sb.append("#").append(t).append(" ").append(sum).append("\n");
		 }//end testCase
		 
		 System.out.println(sb);
	} //end main
	
	private static void rotate(int num, int option) {
		if(option==0) return;
		if(option==1) { //시계방향 회전
			 list[num].add(0, list[num].remove(7));
		} else if(option==-1){ //반시계방향 회전
			 list[num].add(list[num].remove(0));
		}
	}
}
