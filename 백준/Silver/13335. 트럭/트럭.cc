/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13335                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13335                          #+#        #+#      #+#    */
/*   Solved: 2024/03/01 15:13:30 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <queue>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int n, w, L; // 트럭의 수, 다리길이, 다리의 최대하중
int truck_weight[1001];
queue<int> q;

void input()
{
    cin >> n >> w >> L;
    for (int i = 0; i < n; i++)
    {
        cin >> truck_weight[i];
    }
}

void solution()
{
    int cnt = 0, total_weight = 0; // 단위시간 계산, 다리위 트럭의 현재 하중
    for (int i = 0; i < n; i++)
    {
        while (1)
        {
            if (q.size() == w)
            { // 트럭이 다리를 다 건넜을 경우
                total_weight -= q.front();
                q.pop();
            }
            if (total_weight + truck_weight[i] <= L)
                break;
            q.push(0); // 트럭 앞으로 전진
            cnt++;
        }
        q.push(truck_weight[i]); // 새로운 트럭 진입
        total_weight += truck_weight[i];
        cnt++;
    }
    // 마지막 트럭이 진입 후 다리를 건너기 까지 시간을 더해준다.
    cout << cnt + w << endl; 
}

int main()
{
    fastio;
    input();
    solution();
}