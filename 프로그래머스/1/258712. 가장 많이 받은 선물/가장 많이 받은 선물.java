import java.util.*;

class Solution {
    
    static StringTokenizer st;
    static HashMap<String, Integer> hM;
    static int N, M, answer;
    static int[][] gift;
    static int[] score, received;
    
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        M = gifts.length;
        
        hM = new HashMap<>();
        int index = 0;
        for(int i = 0; i < N; i++) {
            hM.put(friends[i], index++);
        }
        
        gift = new int[N][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(gifts[i]);
            int a = hM.get(st.nextToken());
            int b = hM.get(st.nextToken());
            gift[a][b]++; //a가 b에게 선물을 주다
        }
        
        //선물 지수 구하기
        score = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                score[i] += gift[i][j];
                score[i] -= gift[j][i];
            }
        }
        
        //받을 선물 구하기
        received = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                calculate(i, j);
            }
        }
        
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, received[i]);
        }
        return answer;
    }
    
    private static void calculate(int a, int b) {
        if(gift[a][b] == gift[b][a]) {
            if(score[a] > score[b]) received[a]++;
            else if(score[a] < score[b]) received[b]++;
        } else {
            if(gift[a][b] < gift[b][a]) received[b]++;
            else if(gift[a][b] > gift[b][a]) received[a]++;
        }
    }
}