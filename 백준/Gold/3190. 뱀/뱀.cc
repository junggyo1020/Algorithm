#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int N, K, L;
vector<vector<bool>> apple;
deque<pair<int, int>> snake;
vector<pair<int, char>> turns;

bool isInside(int x, int y) {
    return x >= 1 && x <= N && y >= 1 && y <= N;
}

int simulate() {
    int time = 0, direction = 0;  // 초기 방향: 오른쪽
    int dx[4] = {0, 1, 0, -1};    // 상, 우, 하, 좌
    int dy[4] = {1, 0, -1, 0};
    int turn_index = 0;
    snake.push_back({1, 1});
    vector<vector<bool>> occupied(N + 1, vector<bool>(N + 1, false));
    occupied[1][1] = true;

    while (true) {
        time++;
        int nx = snake.front().first + dx[direction];
        int ny = snake.front().second + dy[direction];

        if (!isInside(nx, ny) || occupied[nx][ny]) {
            return time;  // 벽 또는 자기 자신과 충돌
        }

        snake.push_front({nx, ny});
        if (!apple[nx][ny]) {  // 사과가 없다면 꼬리 이동
            auto tail = snake.back();
            snake.pop_back();
            occupied[tail.first][tail.second] = false;
        } else {  // 사과를 먹으면
            apple[nx][ny] = false;
        }
        occupied[nx][ny] = true;

        if (turn_index < L && turns[turn_index].first == time) {
            if (turns[turn_index].second == 'L')
                direction = (direction + 3) % 4;  // 왼쪽으로 90도
            else
                direction = (direction + 1) % 4;  // 오른쪽으로 90도
            turn_index++;
        }
    }
}

int main() {
    cin >> N;
    cin >> K;
    apple = vector<vector<bool>>(N + 1, vector<bool>(N + 1, false));
    for (int i = 0; i < K; i++) {
        int r, c;
        cin >> r >> c;
        apple[r][c] = true;
    }
    cin >> L;
    turns.resize(L);
    for (int i = 0; i < L; i++) {
        cin >> turns[i].first >> turns[i].second;
    }

    cout << simulate() << endl;

    return 0;
}
