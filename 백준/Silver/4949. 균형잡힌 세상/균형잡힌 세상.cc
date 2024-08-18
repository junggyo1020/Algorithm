#include <bits/stdc++.h>
using namespace std;
string s;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    while (1)
    {
        getline(cin, s); // 공백을 포함한 한 줄 입력

        // 입력 종료 조건
        if (s == ".")
        {
            break;
        }

        bool check = true;
        stack<char> st;

        for (char c : s)
        {
            if (c == '(' || c == '[')
            {
                st.push(c);
            }
            else if (c == ')')
            {
                if (!st.empty() && st.top() == '(')
                {
                    st.pop();
                }
                else
                {
                    check = false;
                    break;
                }
            }
            else if (c == ']')
            {
                if (!st.empty() && st.top() == '[')
                {
                    st.pop();
                }
                else
                {
                    check = false;
                    break;
                }
            }
        }
        if (!st.empty())
        {
            check = false;
        }
        if (check)
        {
            cout << "yes\n";
        }
        else
        {
            cout << "no\n";
        }
    }
    return 0;
}