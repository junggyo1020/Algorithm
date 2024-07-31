#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int main()
{
    fastio;
    int n;
    while (scanf("%d", &n) != EOF)
    {
        int cnt = 1, ret = 1;
        while (true)
        {
            // 기저 조건
            if (cnt % n == 0)
            {
                cout << ret << endl;
                break;
            }
            else
            {
                cnt = (cnt * 10) + 1;
                cnt %= n; // 모듈러 분배 연산
                ret++;
            }
        }
    }
}