/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2073                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2073                           #+#        #+#      #+#    */
/*   Solved: 2024/03/27 15:02:17 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int D, P;
    cin >> D >> P;
    vector<pair<int, int>> pipes(P);
    for (int i = 0; i < P; i++)
    {
        cin >> pipes[i].first >> pipes[i].second;
    }
    vector<int> dp(D + 1, -1);
    dp[0] = INT_MAX;
    for (int i = 0; i < P; i++)
    {
        int length = pipes[i].first;
        int capacity = pipes[i].second;
        for (int j = D - length; j >= 0; j--)
        {
            if (dp[j] != -1)
            {
                dp[j + length] = max(dp[j + length], min(dp[j], capacity));
            }
        }
    }
    cout << dp[D] << '\n';
    return 0;
}