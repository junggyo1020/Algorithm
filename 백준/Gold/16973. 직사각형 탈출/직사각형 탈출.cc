#include <iostream>
#include <vector>
#include <queue>
#define endl "\n"
using namespace std;

int n, m, h, w, Sr, Sc, Fr, Fc;
vector<vector<int>> board;
vector<vector<bool>> visited;
const int dx[4] = {1, -1, 0, 0}; // 하, 상, 우, 좌
const int dy[4] = {0, 0, 1, -1};

bool isMovable(int x, int y, int dir) {
    // 하
    if (dir == 0) {
        for (int i = 0; i < w; ++i) {
            if (x + h - 1 < n && board[x + h][y + i] == 1) return false;
        }
    }
    // 상
    else if (dir == 1) {
        for (int i = 0; i < w; ++i) {
            if (x - 1 >= 0 && board[x - 1][y + i] == 1) return false;
        }
    }
    // 우
    else if (dir == 2) {
        for (int i = 0; i < h; ++i) {
            if (y + w - 1 < m && board[x + i][y + w] == 1) return false;
        }
    }
    // 좌
    else if (dir == 3) {
        for (int i = 0; i < h; ++i) {
            if (y - 1 >= 0 && board[x + i][y - 1] == 1) return false;
        }
    }
    return true;
}

int bfs() {
    queue<pair<pair<int, int>, int>> q;
    q.push({{Sr, Sc}, 0});
    visited[Sr][Sc] = true;

    while (!q.empty()) {
        int x = q.front().first.first;
        int y = q.front().first.second;
        int count = q.front().second;
        q.pop();

        if (x == Fr && y == Fc) {
            return count; // 목적지 도달
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx + h <= n && ny >= 0 && ny + w <= m && !visited[nx][ny]) {
                if (isMovable(x, y, i)) {
                    visited[nx][ny] = true;
                    q.push({{nx, ny}, count + 1});
                }
            }
        }
    }

    return -1; // 이동 불가능
}

int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);

    cin >> n >> m;
    board.resize(n + 1, vector<int>(m + 1));
    visited.resize(n + 1, vector<bool>(m + 1, false));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }

    cin >> h >> w >> Sr >> Sc >> Fr >> Fc;
    --Sr; --Sc; --Fr; --Fc;

    cout << bfs() << endl;

    return 0;
}
