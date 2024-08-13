/**
 * 물에 잠기지 않는 최대 개수 출력하기
 */
#include <bits/stdc++.h>
using namespace std;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
const int max_n = 104;
int n, a[max_n][max_n], visited[max_n][max_n];
void dfs(int y, int x, int height)
{
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];
        // 언더/오버플로우 체크
        if (ny < 0 || ny >= n || nx < 0 || nx >= n)
            continue;
        // 근처에 height보다 작은 정수가 있는 경우(물에 잠긴 땅) 체크
        if (a[ny][nx] <= height)
            continue;
        // 이미 방문한 지점인 경우 체크
        if (visited[ny][nx])
            continue;
        dfs(ny, nx, height);
    }
    return;
}
int main()
{
    cin >> n;
    // 입력처리
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> a[i][j];
        }
    }
    // 안전한 영역의 최대 개수 구하기
    int max_area = 0;
    for (int h = 0; h <= 100; h++)
    {
        memset(visited, 0, sizeof(visited));
        int area = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (!visited[i][j] && a[i][j] > h)
                {
                    dfs(i, j, h);
                    area++;
                }
            }
        }
        max_area = max(max_area, area);
    }
    cout << max_area << '\n';
    return 0;
}