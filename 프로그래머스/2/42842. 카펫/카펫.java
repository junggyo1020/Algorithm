class Solution {
    public int[] solution(int brown, int yellow) {
        for(int w = 3; w <= 5000; w++){
            for(int h = 1; h <= 5000; h++){
                int area = (w-2)*(h-2);
                if((yellow == area) && (brown == (w*h)-area)){
                    return new int[]{h,w};
                }
            }
        }
        return null;
    }
}