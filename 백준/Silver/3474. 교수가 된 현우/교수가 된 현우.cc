#include <bits/stdc++.h>
using namespace std;
int t, n, ret2, ret5;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> t;
    while (t--)
    {
        cin >> n;
        ret2 = ret5 = 0;
        // 2의 승수
        for (int i = 2; i <= n; i *= 2)
        {
            ret2 += n / i;
        }
        // 5의 승수
        for (int i = 5; i <= n; i *= 5)
        {
            ret5 += n / i;
        }
        cout << ret5 << '\n';
    }
    return 0;
}