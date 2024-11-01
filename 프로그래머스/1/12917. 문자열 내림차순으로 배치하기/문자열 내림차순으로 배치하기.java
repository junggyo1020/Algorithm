class Solution {
    public String solution(String s) {
        return s.chars()
            .boxed() // Wrapper 형 클래스로 변경
            .sorted((v1, v2) -> v2 - v1)
            .collect(StringBuilder::new, // 반환할 객체 생성
                     StringBuilder::appendCodePoint, // 문자열에 정수가 아닌 문자를 합침
                     StringBuilder::append) // 문자열에 어떻게 합치는 지
            .toString();
    }
}