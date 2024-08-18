/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14502                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14502                          #+#        #+#      #+#    */
/*   Solved: 2024/08/18 16:26:29 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
int n, m, ret;
int a[10][10], visited[10][10];
vector<pair<int, int>> virusList, wallList;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void dfs(int y, int x)
{
    for (int i = 0; i < 4; i++)
    {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 언더/오버플로우 체크
        if (ny < 0 || ny >= n || nx < 0 || nx >= m)
            continue;
        // 조건 처리
        if (visited[ny][nx] || a[ny][nx] == 1)
            continue;
        visited[ny][nx] = 1;
        dfs(ny, nx);
    }
    return;
}
int solve()
{
    // 방문 배열 초기화 하기
    fill(&visited[0][0], &visited[0][0] + 10 * 10, 0);
    for (pair<int, int> b : virusList)
    {
        visited[b.first][b.second] = 1;
        dfs(b.first, b.second);
    }
    int cnt = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (a[i][j] == 0 && !visited[i][j])
                cnt++;
        }
    }
    return cnt;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> a[i][j];
            if (a[i][j] == 2)
            {
                virusList.push_back({i, j});
            }
            if (a[i][j] == 0)
            {
                wallList.push_back({i, j});
            }
        }
    }
    // 벽 3개 세우기
    for (int i = 0; i < wallList.size(); i++)
    {
        for (int j = 0; j < i; j++)
        {
            for (int k = 0; k < j; k++)
            {
                a[wallList[i].first][wallList[i].second] = 1;
                a[wallList[j].first][wallList[j].second] = 1;
                a[wallList[k].first][wallList[k].second] = 1;
                ret = max(ret, solve());
                // 초기화
                a[wallList[i].first][wallList[i].second] = 0;
                a[wallList[j].first][wallList[j].second] = 0;
                a[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    cout << ret << '\n';
    return 0;
}