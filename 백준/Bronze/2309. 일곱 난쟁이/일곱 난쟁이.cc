/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2309                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2309                           #+#        #+#      #+#    */
/*   Solved: 2024/03/11 20:23:43 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;
int a[9];
int main()
{
    fastio;
    for (int i = 0; i < 9; i++)
    {
        cin >> a[i];
    }
    sort(a, a + 9);
    do
    {
        int sum = 0;
        for (int i = 0; i < 7; i++)
            sum += a[i];
        if (sum == 100)
            break;
    } while (next_permutation(a, a + 9));
    for (int i = 0; i < 7; i++)
        cout << a[i] << "\n";
    return 0;
}