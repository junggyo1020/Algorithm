#include <bits/stdc++.h>
using namespace std;
string s;
int lcnt, vcnt;
bool isVowel(int idx)
{
    return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    while (1)
    {
        cin >> s;
        // 기저 조건
        if (s == "end")
        {
            break;
        }
        lcnt = vcnt = 0;
        bool flag = 0;
        bool is_include_v = 0;
        int prev = -1;
        for (int i = 0; i < s.size(); i++)
        {
            int idx = s[i];
            // 모음인 경우
            if (isVowel(idx))
            {
                lcnt++, vcnt = 0, is_include_v = 1; // 모음이 하나이상 포함되어 있으므로 체크
            }
            else
            {
                vcnt++, lcnt = 0;
            }
            // 모음이나 자음이 3개이상 연속하는지 체크
            if (lcnt == 3 || vcnt == 3)
            {
                flag = 1;
            }
            // 같은 글자가 연속으로 2번오는지 체크(단, ee나 oo는 예외)
            if (i >= 1 && (prev == idx) && (idx != 'e' && idx != 'o'))
            {
                flag = 1;
            }
            prev = idx;
        }
        // 모음이 하나도 없는 경우
        if (is_include_v == 0)
        {
            flag = 1;
        }
        if (flag)
        {
            cout << "<" << s << "> is not acceptable." << '\n';
        }
        else
        {
            cout << "<" << s << "> is acceptable." << '\n';
        }
    }
    return 0;
}