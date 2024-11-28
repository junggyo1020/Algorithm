class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        int result = Integer.parseInt(sb.reverse().toString(), 3);
        return result;
    }
}