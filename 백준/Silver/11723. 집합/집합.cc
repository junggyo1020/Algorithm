#include <bits/stdc++.h>
using namespace std;

int m, x;
string cmd;
int s = 0; // 비트마스크로 집합을 관리

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> cmd;
        if (cmd == "add")
        {
            cin >> x;
            s |= (1 << (x - 1)); // x를 집합에 추가
        }
        else if (cmd == "remove")
        {
            cin >> x;
            s &= ~(1 << (x - 1)); // x를 집합에서 제거
        }
        else if (cmd == "check")
        {
            cin >> x;
            cout << ((s & (1 << (x - 1))) ? 1 : 0) << '\n'; // x가 집합에 있는지 확인
        }
        else if (cmd == "toggle")
        {
            cin >> x;
            s ^= (1 << (x - 1)); // x가 있으면 제거, 없으면 추가 (토글)
        }
        else if (cmd == "all")
        {
            s = (1 << 20) - 1; // {1, 2, ..., 20}으로 설정
        }
        else if (cmd == "empty")
        {
            s = 0; // 공집합으로 설정
        }
    }
    return 0;
}
