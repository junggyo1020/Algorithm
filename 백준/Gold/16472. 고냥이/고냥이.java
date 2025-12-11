import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	static int N;
	static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		int len = S.length();

		int alphaCnt = 0; //알파벳 개수
		HashMap<Character, Integer> hm = new HashMap<>();

		//두 포인터
		int lt = 0;
		int rt = 0;
		int maxLen = 0;
		for(rt = 0; rt < len; rt++) {
			char ch = S.charAt(rt);

			//해당 문자가 없거나, 맵이 비어있다면
			if(hm.isEmpty() || !hm.containsKey(ch)) alphaCnt++;
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);

			while(alphaCnt > N) {
				char x = S.charAt(lt);
				hm.put(x, hm.get(x) - 1);
				if(hm.get(x) == 0) {
					hm.remove(x);
					alphaCnt--;
				}
				lt++;
			}

			maxLen = Math.max(maxLen, rt - lt + 1);
		}
		System.out.println(maxLen);
	}
}
