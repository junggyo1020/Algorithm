#include<bits/stdc++.h>
using namespace std;
int main() {
    long long n;
    cin >> n;
    // n(n-1)/2 수식을 계산할 때, 곱셈 연산자 *를 명시적으로 사용하고, 연산 순서에 주의해야 합니다.
    cout << (n * (n - 1)) / 2 << '\n' << 2;
    return 0;
}
