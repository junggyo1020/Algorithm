// 정정교
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 1차(서류) 순위가 높은 순으로 정렬하고, 2차(면접) 순위가 같거나 더 높은 사람을 통과시키자.
 */
public class Main {

	static int T, N;
	static ArrayList<Person> list;

	static class Person implements Comparable<Person> {
		int first, second;

		Person(int first, int second){
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Person o){
			return this.first - o.first;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++){
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			//#1 N명 서류, 면접 순위 저장하기
			for(int i = 0 ; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Person(a, b));
			}

			//#2 서류 성적 높은 순위 순으로 정렬
			Collections.sort(list);

			//#3 적합자 뽑기
			int min_second = list.get(0).second; //서류성적 제일 높은 사람의 면접 점수로 초기화
			int total = 1; //서류 1등은 무조건 적합자
			for(int i = 1; i < list.size(); i++){
				int next = list.get(i).second;
				//#4. 만약 면접 성적이 더 높다면 통과
				if(next < min_second) {
					total++;
					min_second = next;
				}
			}

			//#5. 결과값 누적 저장
			sb.append(total).append('\n');
		}
		//#6. 출력
		System.out.println(sb);
	}
}
