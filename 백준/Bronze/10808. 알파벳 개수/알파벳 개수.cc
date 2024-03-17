/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10808                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10808                          #+#        #+#      #+#    */
/*   Solved: 2024/03/12 18:38:03 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;
int main()
{
    fastio;
    string s;
    int alpha[26] = {
        0,
    };
    cin >> s;
    for (char ch : s)
    {
        alpha[ch - 'a']++;
    }
    for (int i : alpha)
    {
        cout << i << " ";
    }
    return 0;
}
