/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16234                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16234                          #+#        #+#      #+#    */
/*   Solved: 2024/05/10 16:17:52 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <queue>
#include <cmath> //abs
#include <cstring> //memset

#define endl "\n"

using namespace std;

// 선언부
const int MAX_N = 50;
int N, L, R;
int A[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];
int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

bool isInRange(int r, int c)
{
    return r >= 0 && r < N && c >= 0 && c < N;
}

bool canUnion(int diff)
{
    return diff >= L && diff <= R;
}

bool bfs(int r, int c)
{
    vector<pair<int, int>> united; // 연합의 좌표값을 저장
    queue<pair<int, int>> q;       // bfs를 위한 큐
    int total = 0;                 // 연합 내 총 인구수
    q.push({r, c});
    united.push_back({r, c});
    visited[r][c] = true;
    total += A[r][c];

    // 4방향 탐색(BFS)
    while (!q.empty())
    {
        int cur_r = q.front().first;
        int cur_c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = cur_r + dr[i];
            int nc = cur_c + dc[i];

            if (isInRange(nr, nc) && !visited[nr][nc])
            { // 탐색범위를 벗어나는지 확인
                int diff = abs(A[cur_r][cur_c] - A[nr][nc]);
                if (canUnion(diff))
                { // 인구수 차가 범위내에 존재하면
                    q.push({nr, nc});
                    united.push_back({nr, nc});
                    visited[nr][nc] = true;
                    total += A[nr][nc];
                }
            }
        }
    }
    if (united.size() > 1)
        {
            int average = total / united.size();
            for (const auto &pos : united)
            {
                A[pos.first][pos.second] = average;
            }
            return true; // 인구이동 발생 O
        }
    return false; // 인구이동 발생 X
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    // 입력부
    cin >> N >> L >> R;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> A[i][j];
        }
    }
    // 날짜 계산
    int days = 0; // 인구이동이 발생한 기간(결과값)
    while (true)
    {
        bool moved = false;                      // 인구이동이 발생했는지 안했는지 확인
        memset(visited, false, sizeof(visited)); // false로 값 초기화
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!visited[i][j])
                {
                    if (bfs(i, j))
                    {
                        moved = true;
                    }
                }
            }
        }
        if (!moved)
        {
            break;
        }
        days++;
    }

    // 출력부
    cout << days << endl;
    return 0;
}