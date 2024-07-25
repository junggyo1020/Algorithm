#include <bits/stdc++.h>
using namespace std;
int n;
int a[26];
int main()
{
    cin >> n;

    // 성의 개수를 저장하는 배열 생성
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        a[s[0] - 'a']++;
    }
    // 같은 성이 5명 이상인 선수의 성의 첫글자 출력
    string result;
    for (int i = 0; i < 26; i++)
    {
        if (a[i] >= 5)
        {
            result += (char)('a' + i);
        }
    }
    if (result.empty())
    {
        cout << "PREDAJA" << "\n";
    }
    else
    {
        cout << result << "\n";
    }
    return 0;
}