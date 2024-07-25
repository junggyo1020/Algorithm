#include <bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    getline(cin, s);
    for (int i = 0; i < s.length(); i++)
    {
        // 공백
        if (s[i] == ' ')
        {
            continue;
        }
        // 대문자
        else if (s[i] >= 'A' && s[i] <= 'Z')
        {
            s[i] = (s[i] - 'A' + 13) % 26 + 'A';
        }
        // 소문자
        else if (s[i] >= 'a' && s[i] <= 'z')
        {
            s[i] = (s[i] - 'a' + 13) % 26 + 'a';
        }
    }
    for (char ch : s)
    {
        cout << ch;
    }
}