/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1018                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1018                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 23:29:28 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

#include <iostream>
#include <algorithm>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

char board[50][50];

// 체스판 다시 칠하기 비용 계산 함수
int repaintChessBoard(int x, int y)
{
    int endX = x + 8;
    int endY = y + 8;
    int countB = 0; // 첫 칸을 B로 시작하는 경우의 변경 횟수
    int countW = 0; // 첫 칸을 W로 시작하는 경우의 변경 횟수

    for (int i = x; i < endX; i++)
    {
        for (int j = y; j < endY; j++)
        {
            // (i+j)의 합이 짝수인 경우와 홀수인 경우를 나누어 검사
            if ((i + j) % 2 == 0)
            {
                if (board[i][j] != 'B')
                    countB++;
                if (board[i][j] != 'W')
                    countW++;
            }
            else
            {
                if (board[i][j] != 'W')
                    countB++;
                if (board[i][j] != 'B')
                    countW++;
            }
        }
    }
    return min(countB, countW); // 둘 중 최소값 반환
}

int main()
{
    fastio;
    int N, M;
    cin >> N >> M;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];
        }
    }

    int minRepaint = 64; // 최대 변경 가능 횟수는 8*8
    for (int i = 0; i <= N - 8; i++)
    {
        for (int j = 0; j <= M - 8; j++)
        {
            minRepaint = min(minRepaint, repaintChessBoard(i, j));
        }
    }

    cout << minRepaint << endl;
}
