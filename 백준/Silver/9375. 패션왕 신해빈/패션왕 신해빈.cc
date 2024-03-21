/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9375                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9375                           #+#        #+#      #+#    */
/*   Solved: 2024/03/20 12:56:25 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t, n;
    cin >> t;
    while (t--)
    {
        cin >> n;
        map<string, int> clothes;
        for (int i = 0; i < n; i++)
        {
            string name, category;
            cin >> name >> category;
            clothes[category]++;
        }

        int combinations = 1;
        for (auto it = clothes.begin(); it != clothes.end(); ++it)
        {
            combinations *= (it->second + 1);
        }

        // 아무것도 입지 않는 경우를 제외
        cout << combinations - 1 << '\n';
    }
    return 0;
}
