#include <vector>
using namespace std;

vector<int> solution(vector<int> arr) {
    int firstTwoIndex = -1; // 첫 번째 2의 인덱스
    int lastTwoIndex = -1; // 마지막 2의 인덱스

    // arr 배열을 순회하며 첫 번째와 마지막 2의 인덱스를 찾습니다.
    for (int i = 0; i < arr.size(); ++i) {
        if (arr[i] == 2) {
            if (firstTwoIndex == -1) firstTwoIndex = i; // 첫 번째 2의 인덱스를 설정
            lastTwoIndex = i; // 마지막 2의 인덱스를 갱신
        }
    }

    // 2가 하나도 없는 경우
    if (firstTwoIndex == -1) return {-1};

    // 첫 번째 2부터 마지막 2까지의 부분 배열을 반환
    vector<int> answer(arr.begin() + firstTwoIndex, arr.begin() + lastTwoIndex + 1);
    return answer;
}
