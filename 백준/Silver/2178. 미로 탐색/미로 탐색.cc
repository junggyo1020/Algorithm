/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2178                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2178                           #+#        #+#      #+#    */
/*   Solved: 2024/04/15 14:07:08 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <queue>
#define endl "\n"
using namespace std;
vector<vector<int>> graph;
vector<vector<int>> dist;
int n, m;
const int dx[4] = {1, -1, 0, 0};
const int dy[4] = {0, 0, 1, -1};

int bfs(int x, int y)
{
    int cnt = 0;
    queue<pair<int, int>> q;
    q.push({x, y});
    dist[x][y] = 1;
    while (!q.empty())
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        cnt++;
        if (x == n - 1 && y == m - 1)
        {
            return dist[x][y];
        }
        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m)
            {
                if (dist[nx][ny] == 0 && graph[nx][ny] == 1)
                {
                    q.push({nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }
    return -1;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n >> m;
    graph.resize(n, vector<int>(m));
    dist.resize(n, vector<int>(m, 0));
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++)
        {
            graph[i][j] = s[j] - '0';
        }
    }
    cout << bfs(0, 0) << "\n";
    return 0;
}