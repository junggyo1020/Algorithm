#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int minOperations(int A, int K) {
    vector<bool> visited(K * 2, false); // 최대값 K*2까지 고려 (2를 곱하는 경우 고려)
    queue<pair<int, int>> q; // first: 현재값, second: 연산 횟수
    q.push({A, 0});
    visited[A] = true;

    while (!q.empty()) {
        auto [current, steps] = q.front();
        q.pop();

        if (current == K) {
            return steps;
        }

        // 연산 1: A에 1을 더하기
        if (current + 1 < K * 2 && !visited[current + 1]) {
            visited[current + 1] = true;
            q.push({current + 1, steps + 1});
        }

        // 연산 2: A에 2를 곱하기
        if (current * 2 < K * 2 && !visited[current * 2]) {
            visited[current * 2] = true;
            q.push({current * 2, steps + 1});
        }
    }
    return -1; // 이론적으로 도달하지 못하는 경우
}

int main() {
    int A, K;
    cin >> A >> K;
    cout << minOperations(A, K) << endl;
    return 0;
}
