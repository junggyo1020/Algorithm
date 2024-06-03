#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 비교 함수 정의
bool compare(pair<string, string> &a, pair<string, string> &b) {
    if (a.first == b.first) {
        // 멘토가 같다면 멘티를 사전 역순으로 정렬
        return a.second > b.second;
    }
    // 멘토를 사전 순으로 정렬
    return a.first < b.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;
    
    vector<pair<string, string>> mentorMentee(N);
    
    for (int i = 0; i < N; ++i) {
        cin >> mentorMentee[i].first >> mentorMentee[i].second;
    }
    
    // 정렬
    sort(mentorMentee.begin(), mentorMentee.end(), compare);
    
    // 출력
    for (const auto &pair : mentorMentee) {
        cout << pair.first << " " << pair.second << "\n";
    }
    
    return 0;
}
