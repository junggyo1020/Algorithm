/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1978                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1978                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 13:56:02 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <cmath>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"

using namespace std;

// 소수 판별 함수
bool isPrime(int num)
{
    if (num < 2)
    {
        return false;
    }
    for (int i = 2; i <= sqrt(num); i++)
    {
        if (num % i == 0)
        {
            return false; // 나누어 떨어지면 소수가 아님
        }
    }
    return true; // 소수임
}

int main()
{
    int N, count = 0;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        if (isPrime(num))
        {
            count++; // 소수일 경우 카운트 증가
        }
    }

    cout << count; // 소수의 개수 출력
    return 0;
}
