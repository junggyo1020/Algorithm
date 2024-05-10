/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15991                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15991                          #+#        #+#      #+#    */
/*   Solved: 2024/05/10 17:37:40 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>

#define endl "\n"
#define MOD 1000000009

using namespace std;

// 선언부
int T, n;
long long dp[1000001] = {0, 1, 2, 2, 3, 3, 6};

void solution()
{
    for (int i = 7; i <= n; i++)
    {
        dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;
    }
    cout << dp[n] << endl;
}

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    // 입력부
    cin >> T;
    while (T--)
    {
        cin >> n;
        solution();
    }
}