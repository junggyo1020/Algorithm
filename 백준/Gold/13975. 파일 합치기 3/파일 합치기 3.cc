#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int K;
        cin >> K;
        priority_queue<long long, vector<long long>, greater<long long>> pq;

        for (int i = 0; i < K; i++) {
            long long fileSize;
            cin >> fileSize;
            pq.push(fileSize);
        }

        long long totalCost = 0;
        while (pq.size() > 1) {
            long long first = pq.top();
            pq.pop();
            long long second = pq.top();
            pq.pop();

            long long cost = first + second;
            totalCost += cost;
            pq.push(cost);
        }

        cout << totalCost << "\n";
    }
    return 0;
}
