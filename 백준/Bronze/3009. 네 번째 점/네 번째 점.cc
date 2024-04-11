/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3009                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3009                           #+#        #+#      #+#    */
/*   Solved: 2024/04/11 22:27:07 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    vector<pair<int, int>> v;
    pair<int, int> answer;
    for (int i = 0; i < 3; i++)
    {
        int x, y;
        cin >> x >> y;
        v.push_back(make_pair(x, y));
    }

    if (v[0].first == v[1].first)
    {
        answer.first = v[2].first;
    }
    else if (v[0].first == v[2].first)
    {
        answer.first = v[1].first;
    }
    else
    {
        answer.first = v[0].first;
    }

    if (v[0].second == v[1].second)
    {
        answer.second = v[2].second;
    }
    else if (v[0].second == v[2].second)
    {
        answer.second = v[1].second;
    }
    else
    {
        answer.second = v[0].second;
    }

    cout << answer.first << " " << answer.second << "\n";
    return 0;
}