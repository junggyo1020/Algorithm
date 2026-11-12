class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int k = 1; k <= len/2; k++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;
            int nextStart = 0;
            for(int i = 0; i+k <= len; i+=k) {
                String sub = s.substring(i, i+k);
                if(sub.equals(prev)) {
                    count++;
                } else {
                    flush(sb, prev, count);
                    prev = sub;
                    count = 1;
                }
                nextStart = i+k;
            }
            
            flush(sb, prev, count);
            
            //남은 문자열은 그대로 붙여넣는다.
            if(nextStart < len) {
                sb.append(s.substring(nextStart));
            }
            
            //길이 계산
            int size = sb.toString().length();

            //최소길이 갱신
            answer = Math.min(answer, size);
        }
        return answer;
    }
    
    private static void flush(StringBuilder sb, String prev, int count) {
        if(count > 1) sb.append(count).append(prev);
        else sb.append(prev);
    }
}