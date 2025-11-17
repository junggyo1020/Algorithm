import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. O(N^2)은 시간 초과.
 * 2. "나보다 작은 공" = (전체) - (같은 색) 아이디어 사용 -> 누적 합
 * 3. "크기가 같은 공"은 서로를 잡을 수 없다.
 * 4. 해결: 크기별로 묶어서 "1단계: 점수 계산"과 "2단계: 누적 합 갱신"을 분리한다.
 * 5. 최적화: N log N 정렬 대신, 크기가 2000까지인 것을 이용해 크기별 배열(버킷) 사용.
 */

class Ball {
    int idx;
    int color;

    Ball(int idx, int color) {
        this.idx = idx;
        this.color = color;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Ball>[] ballsBySize = new ArrayList[2001];
        for (int i = 0; i <= 2000; i++) {
            ballsBySize[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            ballsBySize[size].add(new Ball(i, color));
        }

        int[] answers = new int[N];
        int[] colorSum = new int[N + 1];
        int totalSum = 0;

        for (int s = 1; s <= 2000; s++) {
            if (ballsBySize[s].isEmpty()) {
                continue;
            }

            List<Ball> currentBatch = ballsBySize[s];
            for (Ball ball : currentBatch) {
                int score = totalSum - colorSum[ball.color];
                answers[ball.idx] = score;
            }

            for (Ball ball : currentBatch) {
                totalSum += s;
                colorSum[ball.color] += s;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answers[i]).append("\n");
        }
        System.out.print(sb);
    }
}