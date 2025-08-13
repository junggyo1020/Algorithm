import java.util.*;
import java.io.*;

class Solution {
    static int N, L, maxScore;
    static int[] scores, cals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            scores = new int[N];
            cals = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;
            for (int k = 1; k <= N; k++) {
                int[] p = new int[N];
                for (int i = 0; i < k; i++) {
                    p[N - 1 - i] = 1;
                }

                // 조합 생성
                do {
                    int currentScore = 0;
                    int currentCal = 0;
                    
                    for (int i = 0; i < N; i++) {
                        if (p[i] == 1) { // 선택된 재료라면
                            currentScore += scores[i];
                            currentCal += cals[i];
                        }
                    }

                    if (currentCal <= L) {
                        maxScore = Math.max(maxScore, currentScore);
                    }
                } while (np(p));
            }
            sb.append("#").append(t).append(" ").append(maxScore).append("\n");
        }
        System.out.print(sb);
    }

    private static boolean np(int[] numbers) {
        int N = numbers.length;
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) --i;
        if (i == 0) return false;

        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) --j;

        swap(numbers, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(numbers, i++, k--);
        }
        return true;
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}