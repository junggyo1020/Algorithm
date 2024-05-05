#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int calculateDifference(vector<int>& arr) {
    int sum = 0;
    for (int i = 0; i < arr.size() - 1; ++i) {
        sum += abs(arr[i] - arr[i+1]);
    }
    return sum;
}

int main() {
    int N;
    cin >> N;
    vector<int> A(N);
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    // 모든 순열에 대해 계산
    sort(A.begin(), A.end()); // 순열을 만들기 위해 정렬
    int maxDifference = 0;
    do {
        // 현재 순열에 대한 차이값 합 계산
        int currentDifference = calculateDifference(A);
        maxDifference = max(maxDifference, currentDifference);
    } while (next_permutation(A.begin(), A.end())); // 다음 순열 생성

    cout << maxDifference << endl;
    return 0;
}
