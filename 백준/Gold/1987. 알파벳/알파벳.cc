/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1987                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1987                           #+#        #+#      #+#    */
/*   Solved: 2024/04/01 11:11:38 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <algorithm>
using namespace std;

int R, C;
char board[21][21];
bool visited[26]; // 알파벳 방문 여부
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
int maxCount = 0;

void dfs(int x, int y, int count)
{
    maxCount = max(maxCount, count);
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A'])
        {
            visited[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, count + 1);
            visited[board[nx][ny] - 'A'] = false;
        }
    }
}

int main()
{
    cin >> R >> C;
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> board[i][j];
        }
    }
    visited[board[0][0] - 'A'] = true;
    dfs(0, 0, 1);
    cout << maxCount << endl;
    return 0;
}
