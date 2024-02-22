/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2475                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2475                           #+#        #+#      #+#    */
/*   Solved: 2024/02/22 21:11:12 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
#define endl "\n"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int x, sum = 0, result = 0;
    for (int i = 0; i < 5; i++)
    {
        cin >> x;
        sum += pow(x, 2);
    }
    result += (sum % 10);
    cout << result;
    return 0;
}