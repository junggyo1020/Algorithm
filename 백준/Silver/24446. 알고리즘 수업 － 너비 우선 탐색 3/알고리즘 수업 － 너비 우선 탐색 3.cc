/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 24446                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/24446                          #+#        #+#      #+#    */
/*   Solved: 2024/05/02 22:28:08 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void bfs(int R, const vector<vector<int>>& adj, vector<int>& depth) {
    queue<int> q;
    q.push(R);
    depth[R] = 0;  // 시작 정점의 깊이는 0

    while (!q.empty()) {
        int current = q.front();
        q.pop();

        for (int neighbor : adj[current]) {
            if (depth[neighbor] == -1) {  // 아직 방문하지 않은 정점
                depth[neighbor] = depth[current] + 1;
                q.push(neighbor);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, R;
    cin >> N >> M >> R;

    vector<vector<int>> adj(N + 1);  // 인접 리스트
    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> depth(N + 1, -1);  // 깊이 초기화

    bfs(R, adj, depth);

    for (int i = 1; i <= N; i++) {
        cout << depth[i] << "\n";
    }

    return 0;
}
