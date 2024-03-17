/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11655                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11655                          #+#        #+#      #+#    */
/*   Solved: 2024/03/17 16:32:04 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
string s;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    getline(cin, s);
    for (int i = 0; i < s.length(); i++)
    {
        if ('a' <= s[i] && s[i] <= 'z')
        {
            s[i] = (s[i] - 'a' + 13) % 26 + 'a';
        }
        else if ('A' <= s[i] && s[i] <= 'Z')
        {
            s[i] = (s[i] - 'A' + 13) % 26 + 'A';
        }
    }
    for (int i = 0; i < s.length(); i++)
    {
        cout << s[i];
    }
}