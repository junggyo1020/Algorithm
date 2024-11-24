class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int length1 = s;
        int length2 = s + overwrite_string.length();
        String answer1 = my_string.substring(0,length1);
        String answer2 = my_string.substring(length2);
        answer = answer1 + overwrite_string + answer2;
        return answer;
    }
}