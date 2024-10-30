class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        // 10진법을 3진법 수를 저장하는 문자열로 저장
        String str = Integer.toString(n, 3);
        // 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        // 3진법이 표현된 문자열을 10진법으로 표현
        return Integer.parseInt(reversed, 3);
    }
}