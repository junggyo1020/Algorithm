/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2869                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2869                           #+#        #+#      #+#    */
/*   Solved: 2024/03/04 14:33:57 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

/* 시뮬레이션을 돌리면 시간초과가 남 -> 수학 공식으로 풀어야할 듯*/
// int goUp(int A, int B, int V)
// {
//     int dist = 0; // 현재 거리를 나타냄
//     int day = 0;  // 현재 지난 일 수를 나타냄
//     // 일단 무한루프, 정상에 도착하면 탈출
//     while (1)
//     {
//         day++;
//         dist += A;
//         if (dist >= V)
//         {
//             return day;
//         }
//         dist -= B;
//     }
// }

int main()
{
    fastio;
    int A, B, V;
    cin >> A >> B >> V;
    int day = (V - B - 1) / (A - B) + 1;
    cout << day << endl;
}