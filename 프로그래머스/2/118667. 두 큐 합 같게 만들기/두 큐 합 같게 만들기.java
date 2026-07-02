class Solution {
    
    static int[] arr;
    static long target;
    static long[] pSum;
    
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int N = len*2;
        arr = new int[N];
        
        for(int i = 0; i < len; i++) {
            arr[i] = queue1[i];
            arr[i+len] = queue2[i];
            target += queue1[i];
            target += queue2[i];
        }
        
        if(target % 2 != 0) return -1;
        target /= 2;
        
        //구간합 구하기
        pSum = new long[N+1];
        for(int i = 1; i <= N; i++) {
            pSum[i] = pSum[i-1] + arr[i-1];
        }
        
        int lt = 0, rt = len;
        int cnt = 0;
        while(rt <= N) {
            long sum = pSum[rt] - pSum[lt];
            if(sum == target) return cnt;
            else if(sum > target) lt++;
            else rt++;
            cnt++;
        }
        return -1;
    }
}