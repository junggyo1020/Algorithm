#include <bits/stdc++.h>
using namespace std;
int H, W;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> H >> W;
    char a[H][W];
    int dist[H][W];
    // 초기 배열 입력
    for (int i = 0; i < H; i++)
    {
        for (int j = 0; j < W; j++)
        {
            cin >> a[i][j];
            // 구름이 있는 경우
            if (a[i][j] == 'c')
            {
                dist[i][j] = 0;
            }
            else
            {
                dist[i][j] = -1;
            }
        }
    }
    // 거리 예측하기
    for (int i = 0; i < H; i++)
    {
        for (int j = 1; j < W; j++)
        {
            // 현재 위치에 구름이 이미 존재하는 경우
            if (dist[i][j] != -1)
                continue;
            // 이전 위치에 구름이 존재하지 않는 경우
            if (dist[i][j - 1] == -1)
                continue;
            dist[i][j] = dist[i][j - 1] + 1;
        }
    }
    // 출력
    for (int i = 0; i < H; i++)
    {
        for (int j = 0; j < W; j++)
        {
            cout << dist[i][j] << " ";
        }
        cout << '\n';
    }
    return 0;
}