#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);

    int n;
    cin >> n;

    int good_words_count = 0;

    while (n--)
    {
        string word;
        cin >> word;
        stack<char> st;

        for (char c : word)
        {
            if (!st.empty() && st.top() == c)
            {
                st.pop();
            }
            else
            {
                st.push(c);
            }
        }

        if (st.empty())
        {
            good_words_count++;
        }
    }
    cout << good_words_count << "\n";
}