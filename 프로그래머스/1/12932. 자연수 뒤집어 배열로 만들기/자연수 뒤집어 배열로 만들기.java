class Solution {
    public int[] solution(long n) {
        // 정수 > String 변환
        String s = Long.toString(n);
        // String을 뒤집는다.
        String sb = new StringBuilder(s).reverse().toString();
        // String을 char 배열로 변경한다.
        char[] ch = sb.toCharArray();
        int[] result = new int[ch.length];
        for(int i = 0; i < result.length; i++){
            result[i] = ch[i] - '0';
        }
        return result;
    }
}