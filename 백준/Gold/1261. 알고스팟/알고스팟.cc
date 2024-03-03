/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1261                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1261                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 11:45:27 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int M, N;
int arr[101][101];
int dist[101][101];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int bfs()
{
    queue<pair<int, int>> q;
    for (int i = 0; i < N; ++i)
    {
        fill(dist[i], dist[i] + M, 1e9); // dist 배열을 무한대로 초기화
    }
    dist[0][0] = 0;
    q.push({0, 0});

    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M)
            {
                if (dist[nx][ny] > dist[x][y] + arr[nx][ny])
                {
                    dist[nx][ny] = dist[x][y] + arr[nx][ny];
                    q.push({nx, ny});
                }
            }
        }
    }

    return dist[N - 1][M - 1];
}

// 미로의 상태를 입력
void input()
{
    cin >> M >> N;
    for (int i = 0; i < N; i++)
    {
        string row;
        cin >> row;
        for (int j = 0; j < M; j++)
        {
            arr[i][j] = row[j] - '0';
        }
    }
}

int main()
{
    fastio;
    input();

    cout << bfs() << endl;

    return 0;
}
