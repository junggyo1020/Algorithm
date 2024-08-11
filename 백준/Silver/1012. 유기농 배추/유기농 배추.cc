/**
 * 연결된 컴포넌트
 * dfs
 */
#include <bits/stdc++.h>
using namespace std;
const int max_n = 54;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
int t, m, n, k, x, y, ret;
int a[max_n][max_n];
bool visited[max_n][max_n];
void dfs(int y, int x)
{
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 오버/언더플로우 체크
        if (ny < 0 || ny >= n || nx < 0 || nx >= m)
            continue;
        // 배추가 안심어져 있는 땅은 제외
        if (a[ny][nx] == 0)
            continue;
        // 방문한 땅은 제외
        if (visited[ny][nx])
            continue;

        dfs(ny, nx);
    }
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);

    // 테스트케이스 수
    cin >> t;

    // 초기 배추 심기
    while (t--)
    {
        ret = 0;
        fill(&a[0][0], &a[0][0] + max_n * max_n, 0);
        fill(&visited[0][0], &visited[0][0] + max_n * max_n, 0);
        cin >> m >> n >> k;
        for (int i = 0; i < k; i++)
        {
            cin >> x >> y;
            a[y][x] = 1;
        }

        // dfs로 찾기
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (a[i][j] == 1 && !visited[i][j])
                {
                    dfs(i, j);
                    ret++;
                }
            }
        }
        // 지렁이 개수 출력
        cout << ret << '\n';
    }
    return 0;
}
