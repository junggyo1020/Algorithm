#include <bits/stdc++.h>
using namespace std;
int psum[100004];
int ret = -10000004;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    // n과 k값 입력
    int n, k;
    cin >> n >> k;
    // 누적합 구하기
    for (int i = 1; i <= n; i++)
    {
        int temp;
        cin >> temp;
        psum[i] = psum[i - 1] + temp;
    }
    // 누적합 중 최대값 뽑기
    for (int i = k; i <= n; i++)
    {
        ret = max(ret, psum[i] - psum[i - k]);
    }
    cout << ret << "\n";
    return 0;
}