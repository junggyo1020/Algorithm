/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2636                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2636                           #+#        #+#      #+#    */
/*   Solved: 2024/02/18 03:12:12 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/**
 * BFS (Breadth-First Search) 매 시간마다 공기와 접촉하는 치즈의 위치를 찾아서 녹입니다. 이 과정에서 공기 중에서만 치즈가 녹으므로,
 * 1. 판의 가장자리에서 시작하여 공기가 닿는 칸을 탐색(BFS)
 * 2. 공기와 접촉하는 치즈 찾기: 판의 가장자리(0,0부터 시작)에 있는 공기에서 시작하여, 공기와 접촉한 치즈 찾기
 * 3. 치즈 녹이기: 공기와 접촉한 치즈를 찾았다면, 해당 치즈를 녹이기! 즉, 치즈의 위치를 0으로 변경.
 * 4. 전체 치즈가 녹는 시간 계산: 위 과정을 반복하여, 치즈가 모두 녹을 때까지의 시간을 계산.
 * 5. 마지막으로 남은 치즈의 수 계산: 모든 치즈가 녹기 직전의 상태에서 치즈의 수를 계산.
 */
#include <iostream>
#include <vector>
#include <queue>
#define endl "\n"
using namespace std;

int n, m;
vector<vector<int>> board;
vector<vector<bool>> visited;
const int dx[4] = {0, 1, 0, -1};
const int dy[4] = {1, 0, -1, 0};

void meltCheeze(int x, int y)
{
    queue<pair<int, int>> q;
    visited[x][y] = true;
    q.push({x, y});

    while (!q.empty())
    {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny])
            {
                if (board[nx][ny] == 0)
                {
                    visited[nx][ny] = true;
                    q.push({nx, ny});
                }
                else
                {
                    board[nx][ny] = 0; // 녹이기
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    board = vector<vector<int>>(n, vector<int>(m)); // 2차원 벡터 초기화

    int cur = 0, prev = 0, time = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 1)
                cur++; // 초기 치즈 개수 확인
        }
    }

    // 치즈가 모두 녹을 때 까지 진행
    while (cur > 0)
    {
        prev = cur;
        visited = vector<vector<bool>>(n, vector<bool>(m, false)); // 2차원 벡터 초기화
        meltCheeze(0, 0);                                          // bfs 시작
        time++;
        cur = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 1)
                {
                    cur++;
                }
            }
        }
    }

    cout << time << endl
         << prev << endl;
}