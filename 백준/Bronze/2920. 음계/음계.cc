/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2920                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2920                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 12:20:17 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

vector<int> v;
vector<int> ascending;
vector<int> descending;
int num[8];

void input()
{
    for (int i = 0; i < 8; i++)
    {
        cin >> num[i];
        v.emplace_back(num[i]);
        ascending.emplace_back(i + 1);
        descending.emplace_back(8 - i);
    }
}
void check()
{
    if (v == ascending)
    {
        cout << "ascending" << endl;
    }
    else if (v == descending)
        cout
            << "descending" << endl;
    else
    {
        cout << "mixed" << endl;
    }
}

int main()
{
    input();
    check();

    return 0;
}