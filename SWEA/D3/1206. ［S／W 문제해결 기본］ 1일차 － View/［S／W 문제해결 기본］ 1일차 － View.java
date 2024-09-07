import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스는 항상 10개로 주어진다.
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();  // 건물의 개수
            int[] buildings = new int[n];

            // 건물의 높이 입력
            for (int i = 0; i < n; i++) {
                buildings[i] = sc.nextInt();
            }

            int viewCount = 0;  // 조망권이 확보된 세대의 수

            // 2번째 건물부터 n-3번째 건물까지 확인
            for (int i = 2; i < n - 2; i++) {
                // 현재 빌딩의 왼쪽 2칸, 오른쪽 2칸의 최고 높이를 찾음
                int leftMax = Math.max(buildings[i - 1], buildings[i - 2]);
                int rightMax = Math.max(buildings[i + 1], buildings[i + 2]);

                // 왼쪽과 오른쪽에서 가장 높은 건물의 높이
                int maxAdjacentHeight = Math.max(leftMax, rightMax);

                // 현재 건물이 양쪽 2칸 건물보다 높을 때 조망권 확보
                if (buildings[i] > maxAdjacentHeight) {
                    viewCount += (buildings[i] - maxAdjacentHeight);  // 확보된 세대의 수만큼 더함
                }
            }

            // 결과 출력
            System.out.println("#" + test_case + " " + viewCount);
        }

        sc.close();
    }
}
