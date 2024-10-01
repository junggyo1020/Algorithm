import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m, j, s, e;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);  // 사과 떨어지는 칸의 개수
        m = Integer.parseInt(input[1]);  // 바구니의 크기
        j = Integer.parseInt(br.readLine());  // 사과의 개수

        // 바구니의 처음과 끝 인덱스 초기화
        s = 1;  // 바구니의 시작점
        e = s + m - 1;  // 바구니의 끝점
        int dist = 0; // 최단 거리

        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());  // 사과가 떨어지는 위치

            // 사과가 바구니 범위 안에 있는 경우
            if (s <= apple && apple <= e) {
                continue;  // 바구니가 움직일 필요 없음
            }

            // 사과가 바구니보다 오른쪽에 있는 경우
            if (apple > e) {
                int move = apple - e;  // 오른쪽으로 이동해야 할 거리
                dist += move;  // 총 이동 거리 누적
                s += move;  // 바구니의 시작점 이동
                e += move;  // 바구니의 끝점 이동
            }

            // 사과가 바구니보다 왼쪽에 있는 경우
            else {
                int move = s - apple;  // 왼쪽으로 이동해야 할 거리
                dist += move;  // 총 이동 거리 누적
                s -= move;  // 바구니의 시작점 이동
                e -= move;  // 바구니의 끝점 이동
            }
        }

        // 바구니가 이동해야 하는 최단거리 출력
        System.out.println(dist);
    }
}
