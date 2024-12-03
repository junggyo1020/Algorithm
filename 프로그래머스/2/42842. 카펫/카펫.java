class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        outerLoop:
        for(int w = 3; w < 5000; w++){
            for(int h = 1; h < 5000; h++){
                if(brown == w*h-yellow && yellow == (w-2)*(h-2)){
                    result[0] = h;
                    result[1] = w;
                    break outerLoop;
                }
            }
        }
        return result;
    }
}