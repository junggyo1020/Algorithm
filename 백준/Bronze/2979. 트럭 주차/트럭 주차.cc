/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2979                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2979                           #+#        #+#      #+#    */
/*   Solved: 2024/03/13 01:38:46 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int a, b, c, start, end;
    int cost = 0;
    int cnt[100] = {0};
    cin >> a >> b >> c;
    for (int i = 0; i < 3; i++)
    {
        cin >> start >> end;
        for (int i = start; i < end; i++)
        {
            cnt[i]++;
        }
    }
    for (int i = 0; i < 100; i++)
    {
        if (cnt[i] == 1)
            cost += a;
        else if (cnt[i] == 2)
            cost += 2 * b;
        else if (cnt[i] == 3)
            cost += 3 * c;
    }
    cout << cost;
}