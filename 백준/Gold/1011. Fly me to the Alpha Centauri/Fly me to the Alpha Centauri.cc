/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1011                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1011                           #+#        #+#      #+#    */
/*   Solved: 2024/04/13 23:10:51 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <cmath>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int T;
    cin >> T;
    long long x, y;
    for (int i = 0; i < T; i++)
    {
        long long move, max = 0;
        cin >> x >> y;
        // 모든 수는 n*n + A로 표현 가능
        // 작동횟수 2*n - 1과 ceil(A/n) 값을 더해주면 됨
        while (max * max <= y - x)
        {
            max++;
        }
        // 이떄의 max값은 n, a값도 구하자
        max--;
        move = 2 * max - 1;
        long long a = (y - x) - (max * max);
        a = (long long)ceil((double)a / (double)max);
        move += a;
        cout << move << "\n";
    }
}