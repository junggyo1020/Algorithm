import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

	static List<Point> list;
	static boolean[] visited;
	static HashSet<String> returnSet;
	static String str;

	static class Point {
		int y, x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		//1. 괄호 쌍 찾기
		list = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') dq.push(i);
			else if(ch == ')'){
				list.add(new Point(dq.pop(), i));
			}
		}

		// //1-2. 괄호쌍이 잘 모였는지 확인하기
		// for(Point p : list){
		// 	System.out.println(p.y + " " + p.x);
		// }

		//2. 조합 구하기
		visited = new boolean[list.size()];
		returnSet = new HashSet<>();
		dfs(0);

		//3. 가능한 결과값 사전순으로 정렬 후 출력
		List<String> answer = new ArrayList<>(returnSet);
		Collections.sort(answer);

		for(String x : answer){
			System.out.println(x);
		}
	}

	private static void dfs(int pos){
		if(pos == list.size()){
			boolean flag = false;
			for(boolean x : visited){
				if(x){
					flag = true;
					break;
				}
			}

			if(flag){
				StringBuilder sb = new StringBuilder();
				boolean[] check = new boolean[str.length()];

				for(int i = 0; i < list.size(); i++){
					if(visited[i]){
						Point p = list.get(i);
						check[p.y] = true;
						check[p.x] = true;
					}
				}

				for(int i = 0; i < str.length(); i++){
					if(!check[i]) {
						sb.append(str.charAt(i));
					}
				}
				returnSet.add(sb.toString());
			}

			return;
		}

		visited[pos] = true;
		dfs(pos + 1);
		visited[pos] = false;
		dfs(pos + 1);
	}
}
