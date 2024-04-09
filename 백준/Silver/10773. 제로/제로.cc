/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10773                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10773                          #+#        #+#      #+#    */
/*   Solved: 2024/04/09 16:44:28 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0);
    int k, num;
    int sum = 0;
    cin >> k;
    vector<int> v(k, 0);
    for (int i = 0; i < k; i++)
    {
        cin >> num;
        if (num == 0)
        {
            v.pop_back();
        }
        else
        {
            v.push_back(num);
        }
    }

    for (int i = 0; i < v.size(); i++)
    {
        sum += v[i];
    }
    cout << sum << '\n';
    return 0;
}