#include <bits/stdc++.h>
using namespace std;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
const int max_n = 101;
int n, m, k, sx, sy, ex, ey, cnt;
int a[max_n][max_n], visited[max_n][max_n];
vector<int> areas;
int bfs(int y, int x)
{
    queue<pair<int, int>> q;
    visited[y][x] = 1;
    q.push({y, x});
    int area = 0;
    while (!q.empty())
    {
        tie(y, x) = q.front();
        q.pop();
        area++;
        for (int i = 0; i < 4; i++)
        {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 언더/오버플로우 체크
            if (ny < 0 || ny >= m || nx < 0 || nx >= n)
            {
                continue;
            }
            // 이미 방문한 노드인지 체크
            if (visited[ny][nx])
            {
                continue;
            }
            if (a[ny][nx] == 1)
            {
                continue;
            }
            visited[ny][nx] = 1;
            q.push({ny, nx});
        }
    }
    return area;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> m >> n >> k;
    // 직사각형 채우기
    while (k--)
    {
        cin >> sx >> sy >> ex >> ey;
        for (int i = sy; i < ey; i++)
        {
            for (int j = sx; j < ex; j++)
            {
                a[i][j] = 1;
            }
        }
    }
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (!visited[i][j] && a[i][j] == 0)
            {
                int area = bfs(i, j);
                areas.push_back(area);
                cnt++;
            }
        }
    }
    sort(areas.begin(), areas.end());
    cout << cnt << '\n';
    for (int area : areas)
    {
        cout << area << ' ';
    }
    cout << '\n';
    return 0;
}