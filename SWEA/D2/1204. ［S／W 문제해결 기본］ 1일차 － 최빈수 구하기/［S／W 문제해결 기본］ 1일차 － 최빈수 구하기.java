import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String args[]) throws Exception {
        // 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스의 수를 읽어옵니다.

        // 여러 개의 테스트 케이스를 처리합니다.
        for(int test_case = 1; test_case <= T; test_case++) {
            // 테스트 케이스 번호를 읽어옵니다. (실제로 필요하지 않으면 이 라인은 생략 가능합니다)
            int caseNumber = sc.nextInt(); 

            // 학생들의 점수를 배열로 읽어옵니다.
            int[] scores = new int[1000];
            for(int i = 0; i < 1000; i++) {
                scores[i] = sc.nextInt();
            }

            // 점수 빈도를 기록하기 위한 HashMap 생성
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for(int score : scores) {
                frequencyMap.put(score, frequencyMap.getOrDefault(score, 0) + 1);
            }

            // 최빈수를 계산합니다.
            int mode = -1;
            int maxFrequency = -1;

            for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                int score = entry.getKey();
                int frequency = entry.getValue();

                // 최빈수 찾기: 빈도가 높은 점수, 빈도가 같다면 더 큰 점수를 선택
                if (frequency > maxFrequency || (frequency == maxFrequency && score > mode)) {
                    maxFrequency = frequency;
                    mode = score;
                }
            }

            // 결과 출력
            System.out.println("#" + test_case + " " + mode);
        }
    }
}
