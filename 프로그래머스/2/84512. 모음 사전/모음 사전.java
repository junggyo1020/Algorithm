import java.util.*;

class Solution {
    private static final String CHARS = "AEIOU";
    
    private static void generated(String word, List<String> words){
        words.add(word);
        
        if(word.length() == 5) return;
        
        for(char c : CHARS.toCharArray()){
            generated(word + c, words);
        }
    }
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generated("", words);
        return words.indexOf(word);
    }
}