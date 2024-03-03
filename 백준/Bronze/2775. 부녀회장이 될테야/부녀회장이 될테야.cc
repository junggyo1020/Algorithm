/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2775                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2775                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 22:38:53 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int T, k, n;
int sum = 0;
int people[15][15];

void initialize()
{
    // 0층의 i호에는 i명이 산다.
    for (int i = 1; i <= 14; i++)
    {
        people[0][i] = i;
    }
    // i층의 j호에는 = i-1층 j호 + i층 j-1호 의 사람이 산다.
    for (int i = 1; i <= 14; i++)
    {
        for (int j = 1; j <= 14; j++)
        {
            people[i][j] = people[i - 1][j] + people[i][j - 1];
        }
    }
}
int main()
{
    fastio;
    cin >> T;

    initialize();

    for (int i = 0; i < T; i++)
    {
        cin >> k >> n;
        cout << people[k][n] << endl;
    }
}

/**
 *
 * 1 4 10
 * 1 3 6
 * 1 2 3
 */