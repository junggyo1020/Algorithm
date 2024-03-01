/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10250                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10250                          #+#        #+#      #+#    */
/*   Solved: 2024/03/01 17:55:16 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int T;
int H, W, N;

void solution(int N)
{
    int floor = N % H;
    if (floor == 0)
        floor = H;
    floor *= 100;

    int room = N / H;
    if (N % H != 0)
        room += 1;
    cout << floor + room << endl;
}

void input()
{
    cin >> T;
    while (T--)
    {
        cin >> H >> W >> N;
        solution(N);
    }
}

int main()
{
    fastio;
    input();
}