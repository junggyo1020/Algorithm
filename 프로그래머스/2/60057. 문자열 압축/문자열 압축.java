import java.util.*;

class Solution {

	static StringBuilder sb;
	static StringBuilder result;
	static String answer;
	static int minLen;

    public int solution(String s) {
		char[] ch = s.toCharArray();

        //문자열 자르는 단위 순회
		minLen = s.length();
		for(int k = 1; k <= s.length(); k++) {
			String prev = "";
			result = new StringBuilder();
			int cnt = 1;

			int lastIdx = 0;
			for(int i = 0; i+k < s.length(); i+=k) {
				sb = new StringBuilder();
				for(int j = i; j < i+k; j++) {
					sb.append(ch[j]);
				}
				if(prev.equals(sb.toString())) {
					cnt++;
				} else {
					if(cnt > 1) result.append(cnt);
					result.append(sb);
					prev = sb.toString();
					cnt = 1;
				}
				lastIdx = i+k;
			}

			//나머지 부분 채우기
			sb = new StringBuilder();
			for(int i = lastIdx; i < s.length(); i++) {
				sb.append(ch[i]);
			}

			if(prev.equals(sb.toString())) {
				cnt++;
				result.append(cnt);
			} else {
				if(cnt > 1) result.append(cnt);
				result.append(sb);
				prev = sb.toString();
				cnt = 1;
			}

			if(result.length() < minLen) minLen = result.length();
		}

		return minLen;
    }
}