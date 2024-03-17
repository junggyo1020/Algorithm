/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1159                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1159                           #+#        #+#      #+#    */
/*   Solved: 2024/03/16 23:15:14 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;
string arr[150];
string answer = "";
int n;
int cnt[26];
int main()
{
    fastio;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        cnt[arr[i][0] - 'a']++;
    }
    for (int i = 0; i < 26; i++)
    {
        if (cnt[i] >= 5)
        {
            answer += (char)(i + 'a');
        }
    }
    if (answer != "")
    {
        cout << answer << '\n';
    }
    else
    {
        cout << "PREDAJA" << '\n';
    }
    return 0;
}
