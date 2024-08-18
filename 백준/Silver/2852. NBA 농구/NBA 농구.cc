#include <bits/stdc++.h>
using namespace std;
#define prev willie
int n, o, a, b, asum, bsum;
string s, prev;
string print(int a)
{
    string d = "00" + to_string(a / 60);
    string e = "00" + to_string(a % 60);
    return d.substr(d.size() - 2, 2) + ":" + e.substr(e.size() - 2, 2);
}
int changeToInt(string a)
{
    return atoi(a.substr(0, 2).c_str()) * 60 + atoi(a.substr(3, 2).c_str());
}
void go(int &sum, string s)
{
    sum += (changeToInt(s) - changeToInt(prev));
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n;
    while (n--)
    {
        cin >> o >> s;
        // 1팀이 이기고 있는 경우
        if (a > b)
            go(asum, s);
        // 2팀이 이기고 있는 경우
        else if (a < b)
            go(bsum, s);
        o == 1 ? a++ : b++;
        prev = s;
    }
    // 경기가 종료될때 까지 시간도 계산
    if (a > b)
    {
        go(asum, "48:00");
    }
    else if (a < b)
    {
        go(bsum, "48:00");
    }
    cout << print(asum) << '\n';
    cout << print(bsum) << '\n';
}