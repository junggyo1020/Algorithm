#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<string> gears(4);
int K;

void rotate(int gear, int direction) {
    if (direction == 1) { // 시계 방향
        gears[gear] = gears[gear].back() + gears[gear].substr(0, gears[gear].size() - 1);
    } else { // 반시계 방향
        gears[gear] = gears[gear].substr(1) + gears[gear].front();
    }
}

int main() {
    // 톱니바퀴 상태 입력
    for (int i = 0; i < 4; ++i) {
        cin >> gears[i];
    }
    
    cin >> K; // 회전 횟수 입력
    while (K--) {
        int number, direction;
        cin >> number >> direction;
        number--; // 인덱스 맞추기

        vector<int> directions(4, 0); // 각 톱니바퀴의 회전 방향
        directions[number] = direction;

        // 왼쪽 톱니바퀴 검사
        for (int i = number; i > 0; --i) {
            if (gears[i][6] != gears[i-1][2]) {
                directions[i-1] = -directions[i];
            } else {
                break;
            }
        }

        // 오른쪽 톱니바퀴 검사
        for (int i = number; i < 3; ++i) {
            if (gears[i][2] != gears[i+1][6]) {
                directions[i+1] = -directions[i];
            } else {
                break;
            }
        }

        // 계산된 방향대로 톱니바퀴 회전
        for (int i = 0; i < 4; ++i) {
            if (directions[i] != 0) {
                rotate(i, directions[i]);
            }
        }
    }

    // 점수 계산
    int score = 0;
    for (int i = 0; i < 4; ++i) {
        if (gears[i][0] == '1') {
            score += (1 << i);
        }
    }

    cout << score << endl;

    return 0;
}
