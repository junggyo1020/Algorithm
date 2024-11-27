class Solution {
    public String solution(String s) {
        boolean toUpper = true;
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                toUpper = true;
                sb.append(c);
                continue;
            } else {
                if(toUpper){
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            toUpper = !toUpper;
        }
        
        return sb.toString();
    }
}