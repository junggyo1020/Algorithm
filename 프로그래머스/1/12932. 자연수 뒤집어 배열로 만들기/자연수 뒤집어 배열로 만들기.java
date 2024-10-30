class Solution {
    public int[] solution(long n) {
        // 자연수 n을 문자열로 변환
        String str = Long.toString(n);
        // 문자열을 뒤집는다
        String reversed = new StringBuilder(str).reverse().toString();
        // 뒤집은 문자열을 문자의 배열로 변환한다
        char[] ch = reversed.toCharArray();
        // 변환된 문자를 숫자 배열에 옮긴다
        int[] arr = new int[ch.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = ch[i] - '0';
        }
        // 결과를 반환한다
        return arr;
    }
}