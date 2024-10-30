class Solution {
    boolean solution(String s) {
        // 문자열을 소문자로 변환
        s = s.toLowerCase();
        // 기존 문자열과 현재 문자열 길이의 차 = "p"의 개수
        int ps = s.length() - s.replace("p","").length();
        // "y" 개수 구하기
        int ys = s.length() - s.replace("y","").length();
        // 개수 비교
        return ps == ys;
    }
}