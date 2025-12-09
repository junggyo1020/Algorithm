import java.util.*;

class Solution {
    // 1. 전역 변수로 Map 선언 (어디서든 쓰기 편하게)
    // Key: "javabackendjuniorpizza" 같은 조합 문자열
    // Value: 점수 리스트 [150, 200, 80 ...]
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        
        // [단계 1] 지원자 정보를 Map에 정리하기
        for (String i : info) {
            String[] data = i.split(" "); 
            makeSentence(data, "", 0);
        }

        // [단계 2] 각 그룹의 점수 리스트를 오름차순 정렬하기
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // [단계 3] 쿼리(질문) 하나씩 처리하기
        int[] answer = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {
            String str = query[i].replace(" and ", "");
            String[] q = str.split(" "); // 공백으로 자르면 앞부분은 조건, 뒷부분은 점수
            
            String condition = q[0];     // 찾으려는 조건 (예: javabackendjuniorpizza)
            int targetScore = Integer.parseInt(q[1]); // 기준 점수 (예: 100)

            // 점수 계산 (이분 탐색)
            answer[i] = binarySearch(condition, targetScore);
        }

        return answer;
    }

    static void makeSentence(String[] data, String str, int depth) {
        // 4가지 조건(언어, 직무, 경력, 음식)을 다 조합했으면 종료
        if (depth == 4) {
            int score = Integer.parseInt(data[4]); // 점수 가져오기
            
            // Map에 없는 키면 리스트 새로 만들기
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            // 점수 추가
            map.get(str).add(score);
            return;
        }

        // 1. 현재 조건을 그대로 선택하는 경우 (예: "java")
        makeSentence(data, str + data[depth], depth + 1);
        
        // 2. 현재 조건을 "-" (상관없음)으로 선택하는 경우 (예: "-")
        makeSentence(data, str + "-", depth + 1);
    }

    static int binarySearch(String key, int targetScore) {
        if (!map.containsKey(key)) return 0;

        ArrayList<Integer> scores = map.get(key);
        
        int left = 0;
        int right = scores.size();

        // targetScore보다 크거나 같은 첫 번째 점수의 위치 찾기
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (scores.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // (전체 인원 수) - (기준 점수보다 낮은 사람 수) = 합격자 수
        return scores.size() - left;
    }
}