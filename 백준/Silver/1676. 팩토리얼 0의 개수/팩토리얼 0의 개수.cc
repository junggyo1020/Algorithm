/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1676                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1676                           #+#        #+#      #+#    */
/*   Solved: 2024/03/04 16:21:31 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int main()
{
    fastio;
    int N;
    cin >> N;

    // 뒤에서부터 순회하면서 0의 개수 확인하기
    int cnt_0 = 0; // 0의 개수
    for (int i = 5; N / i >= 1; i *= 5)
    {
        cnt_0 += N / i;
    }
    cout << cnt_0 << endl;
}