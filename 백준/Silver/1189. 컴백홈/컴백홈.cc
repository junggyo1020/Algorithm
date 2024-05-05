#include <iostream>
#include <vector>
#include <string>
using namespace std;

int R, C, K;
vector<string> grid;
vector<vector<bool>> visited;
int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 하, 상, 우, 좌
int countPaths = 0;

void dfs(int x, int y, int steps) {
    // 도착점에 도달하고 거리가 K인 경우
    if (x == 0 && y == C-1 && steps == K) {
        countPaths++;
        return;
    }

    // 이동 가능한 다음 위치 탐색
    for (auto dir : directions) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        // 격자 범위 안에 있고, 방문하지 않았으며, 통과 가능한 경우
        if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && grid[nx][ny] == '.') {
            visited[nx][ny] = true;
            dfs(nx, ny, steps + 1);
            visited[nx][ny] = false;  // 백트래킹
        }
    }
}

int main() {
    cin >> R >> C >> K;
    grid.resize(R);
    visited.resize(R, vector<bool>(C, false));

    for (int i = 0; i < R; i++) {
        cin >> grid[i];
    }

    // 시작 지점 방문 처리 및 DFS 시작
    visited[R-1][0] = true;
    dfs(R-1, 0, 1);  // 시작점에서 시작하므로 거리는 1부터 시작

    cout << countPaths << endl;
    return 0;
}
