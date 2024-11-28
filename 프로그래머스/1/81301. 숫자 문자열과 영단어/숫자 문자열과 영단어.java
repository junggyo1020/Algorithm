class Solution {
    
    private static final String[] words = {"zero", "one", "two", "three",
                                           "four", "five", "six", "seven",
                                           "eight", "nine", "ten"};
    
    public int solution(String s) {
        for(int i = 0; i < 10; i++){
            s = s.replace(words[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}