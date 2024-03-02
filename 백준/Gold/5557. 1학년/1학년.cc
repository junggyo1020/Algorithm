/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5557                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5557                           #+#        #+#      #+#    */
/*   Solved: 2024/03/01 16:02:18 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int N;                 // 숫자의 개수
int arr[100];          // N개의 정수 배열 저장
long long dp[100][21]; // dp[i][j] : i번째까지 숫자로 j를 만들 수 있는 올바른 등식의 개수

void input()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
}

void do_dp()
{
    dp[0][arr[0]] = 1; // 첫번째 숫자로 첫번째 숫자를 만드는 경우는 오직 하나
    for (int i = 1; i < N - 1; i++)
    {
        for (int j = 0; j < 21; j++)
        {
            if (dp[i - 1][j] > 0)
            { // j를 만들 수 있는 경우
                int add = j + arr[i];
                int sub = j - arr[i];
                if (add < 21)
                {
                    dp[i][add] += dp[i - 1][j];
                }
                if (sub >= 0)
                {
                    dp[i][sub] += dp[i - 1][j];
                }
            }
        }
    }
    cout << dp[N - 2][arr[N - 1]];
}

int main()
{
    input();
    do_dp();
}