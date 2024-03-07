/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10814                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10814                          #+#        #+#      #+#    */
/*   Solved: 2024/03/06 13:31:56 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <algorithm>
#include <vector>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

bool compare(pair<int, string> a, pair<int, string> b)
{
    return a.first < b.first;
}
int main()
{
    fastio;
    int N, age;
    string name;
    cin >> N;
    vector<pair<int, string>> vec;

    for (int i = 0; i < N; i++)
    {
        cin >> age >> name;
        vec.push_back(make_pair(age, name));
    }

    stable_sort(vec.begin(), vec.end(), compare);

    for (int i = 0; i < N; i++)
    {
        cout << vec[i].first << " " << vec[i].second << endl;
    }

    return 0;
}