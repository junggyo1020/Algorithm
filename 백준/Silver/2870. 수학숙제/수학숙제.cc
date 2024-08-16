#include <bits/stdc++.h>
using namespace std;
int n;
vector<string> v;
string s, ret;
// 담긴 문자열 처리
void go()
{
    while (1)
    {
        // 0070인 경우 0을 생략하고 70만 남기기
        if (ret.size() && ret.front() == '0')
        {
            ret.erase(ret.begin());
        }
        else
        {
            break;
        }
    }
    // 0을 지운 이후에 문자열에 아무것도 남지 않으면 0으로 인식
    if (ret.size() == 0)
    {
        ret = '0';
    }
    v.push_back(ret);
    ret = "";
}
bool cmp(string a, string b)
{
    if (a.size() == b.size())
    {
        return a < b;
    }
    return a.size() < b.size();
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n;
    while (n--)
    {
        cin >> s;
        ret = "";
        for (int i = 0; i < s.size(); i++)
        {
            // 숫자인 경우를 문자열에 담기
            if (s[i] < 65)
            {
                ret += s[i];
            }
            // 숫자가 하나라도 존재하는 경우
            else if (ret.size())
            {
                go();
            }
        }
        if (ret.size())
            go();
    }
    sort(v.begin(), v.end(), cmp);
    for (string i : v)
    {
        cout << i << '\n';
    }
    return 0;
}