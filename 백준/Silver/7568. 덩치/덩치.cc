/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7568                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7568                           #+#        #+#      #+#    */
/*   Solved: 2024/04/09 11:39:32 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<pair<int, int>> v(n); // 몸무게, 키
    vector<int> rank(n, 1);      // 등수를 저장

    for (int i = 0; i < n; i++)
    {
        cin >> v[i].first >> v[i].second;
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (v[i].first < v[j].first && v[i].second < v[j].second)
            {
                rank[i]++;
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        cout << rank[i] << " ";
    }
    cout << "\n";
    return 0;
}