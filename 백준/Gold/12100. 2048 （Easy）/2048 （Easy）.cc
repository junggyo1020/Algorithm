#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX_N = 20;
int N;
int board[MAX_N][MAX_N];

void tilt(int dir) {
    bool merged[MAX_N][MAX_N] = {false}; // 합쳐진 블록을 추적하는 배열

    switch (dir) {
        case 0: // 왼쪽
            for (int i = 0; i < N; i++) {
                int index = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) continue;
                    if (index > 0 && board[i][index - 1] == board[i][j] && !merged[i][index - 1]) {
                        board[i][index - 1] *= 2;
                        merged[i][index - 1] = true;
                    } else {
                        board[i][index++] = board[i][j];
                    }
                    if (j != index - 1) board[i][j] = 0;
                }
            }
            break;

        case 1: // 위쪽
            for (int j = 0; j < N; j++) {
                int index = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] == 0) continue;
                    if (index > 0 && board[index - 1][j] == board[i][j] && !merged[index - 1][j]) {
                        board[index - 1][j] *= 2;
                        merged[index - 1][j] = true;
                    } else {
                        board[index++][j] = board[i][j];
                    }
                    if (i != index - 1) board[i][j] = 0;
                }
            }
            break;

        case 2: // 오른쪽
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] == 0) continue;
                    if (index < N - 1 && board[i][index + 1] == board[i][j] && !merged[i][index + 1]) {
                        board[i][index + 1] *= 2;
                        merged[i][index + 1] = true;
                    } else {
                        board[i][index--] = board[i][j];
                    }
                    if (j != index + 1) board[i][j] = 0;
                }
            }
            break;

        case 3: // 아래쪽
            for (int j = 0; j < N; j++) {
                int index = N - 1;
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] == 0) continue;
                    if (index < N - 1 && board[index + 1][j] == board[i][j] && !merged[index + 1][j]) {
                        board[index + 1][j] *= 2;
                        merged[index + 1][j] = true;
                    } else {
                        board[index--][j] = board[i][j];
                    }
                    if (i != index + 1) board[i][j] = 0;
                }
            }
            break;
    }
}

int maxBlock = 0;

// DFS 함수로 최대 5번 이동
void dfs(int depth) {
    if (depth == 5) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                maxBlock = max(maxBlock, board[i][j]);
        return;
    }

    int copy[MAX_N][MAX_N];
    memcpy(copy, board, sizeof(board)); // 현재 상태 복사

    for (int i = 0; i < 4; i++) {
        tilt(i); // i 방향으로 이동
        dfs(depth + 1); // 다음 깊이 탐색
        memcpy(board, copy, sizeof(board)); // 원상태로 복구
    }
}

int main() {
    cin >> N;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> board[i][j];

    dfs(0);

    cout << maxBlock << endl;
    return 0;
}
