/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9012                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9012                           #+#        #+#      #+#    */
/*   Solved: 2024/03/05 16:42:26 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <stack>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

string isValid(string s)
{
    stack<char> st;
    for (char c : s)
    {
        // '('를 넣어야 하는 경우
        if (c == '(')
        {
            st.push(c); // 일단 스택에 넣음
        }
        else
        { // ')'를 스택에 넣어야하는 경우
            if (st.empty())
            { //')'를 입력받는 경우에 stack이 비어있는 경우 ))이런 경우 VPS(X)
                return "NO";
            }
            st.pop();
        }
    }
    return st.empty() ? "YES" : "NO";
}

int main()
{
    int T;
    cin >> T;
    while (T--)
    {
        string s;
        cin >> s;
        cout << isValid(s) << endl;
    }
}