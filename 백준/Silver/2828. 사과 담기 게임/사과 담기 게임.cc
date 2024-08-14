#include <bits/stdc++.h>
using namespace std;
int n, m, j, l, r, tem, ret;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n >> m >> j;
    l = 1;
    for (int i = 0; i < j; i++)
    {
        r = l + m - 1; // 바구니 크기에 따라 다르게 조정
        cin >> tem;
        // 바구니가 움직이지 않고 사과를 받을 수 있는 경우
        if (l <= tem && tem <= r)
        {
            continue;
        }
        else
        {
            // 떨어지는 사과보다 바구니가 오른쪽에 있음
            if (tem < l)
            {
                ret += l - tem;
                l = tem;
            }
            // 왼쪽에 있음
            else
            {
                ret += tem - r;
                l += tem - r;
            }
        }
    }
    cout << ret << '\n';
    return 0;
}