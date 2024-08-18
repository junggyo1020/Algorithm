/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1325                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1325                           #+#        #+#      #+#    */
/*   Solved: 2024/08/18 20:27:48 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
int n, m, s, e, mx;
vector<int> adj[10004];
int visited[10004], dp[10004];
int dfs(int here)
{
    visited[here] = 1;
    int ret = 1;
    for (int there : adj[here])
    {
        if (visited[there])
            continue;
        ret += dfs(there);
    }
    return ret;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n >> m;
    // 간선 입력
    for (int i = 0; i < m; i++)
    {
        cin >> s >> e;
        adj[e].push_back(s);
    }
    // dfs로 최대 거리 구하기
    for (int i = 1; i <= n; i++)
    {
        fill(&visited[0], &visited[0] + 10004, 0);
        dp[i] = dfs(i);
        mx = max(dp[i], mx);
    }
    for (int i = 1; i <= n; i++)
    {
        if (mx == dp[i])
            cout << i << " ";
    }
    return 0;
}