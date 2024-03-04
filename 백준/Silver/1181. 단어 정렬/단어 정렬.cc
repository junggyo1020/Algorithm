/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1181                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1181                           #+#        #+#      #+#    */
/*   Solved: 2024/03/04 11:54:20 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

vector<string> s;
// 중복체크, 길이가 짧은것으로 정렬, 길이가 같은 경우 사전순으로
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        string str;
        cin >> str;
        s.emplace_back(str);
    }

    // 길이 순으로 정렬, 사전순으로 정렬
    sort(s.begin(), s.end(), [](const string &a, const string &b)
         {
             if (a.size() == b.size())
                 return a < b;           // 길이가 같다면 사전순으로 정렬
             return a.size() < b.size(); // 그렇지 않다면 길이가 짧은 순으로 정렬
         });

    // 중복 제거
    s.erase(unique(s.begin(), s.end()), s.end());

    for (auto &x : s)
    {
        cout << x << endl;
    }
    return 0;
}