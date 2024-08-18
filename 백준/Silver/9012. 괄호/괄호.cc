/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9012                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9012                           #+#        #+#      #+#    */
/*   Solved: 2024/08/18 14:51:26 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
int t;
string result;
int main()
{
    cin >> t;
    while (t--)
    {
        string s = "";
        stack<char> st;
        cin >> s;
        for (char ch : s)
        {
            if (ch == '(')
            {
                st.push('(');
            }
            else
            {
                // st.top()을 빈 스택에서 호출할 경우 런타임 에러가 발생한다.
                if (!st.empty() && st.top() == '(')
                {
                    st.pop();
                }
                else
                {
                    st.push(')');
                }
            }
        }
        // 스택이 비어있으면 YES, 아니면 NO 출력
        result = st.empty() ? "YES" : "NO";
        cout << result << '\n';
    }
}