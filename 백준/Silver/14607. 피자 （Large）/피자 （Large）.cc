#include <iostream>
#include <cstdio>
#include <map>

using namespace std;

typedef long long ll;

// 메모이제이션을 위한 맵
map<ll, ll> memo;

// 최대 즐거움을 계산하는 재귀 함수
ll calculateMaxFun(ll n) {
    if (n == 1 || memo[n]) {
        return memo[n];
    }

    if (n % 2 == 1) {
        memo[n] = calculateMaxFun(n / 2) + calculateMaxFun(n / 2 + 1) + (n / 2) * (n / 2 + 1);
    } else {
        memo[n] = calculateMaxFun(n / 2) + calculateMaxFun(n / 2) + (n / 2) * (n / 2);
    }

    return memo[n];
}

int main() {
    ll n;

    // 입력
    scanf("%lld", &n);
    memo[1] = 0;  // 초기값 설정
    memo[2] = 1;  // 초기값 설정

    // 함수 호출
    calculateMaxFun(n);

    // 결과 출력
    printf("%lld", memo[n]);
    return 0;
}
