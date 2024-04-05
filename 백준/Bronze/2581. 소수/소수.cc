/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2581                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2581                           #+#        #+#      #+#    */
/*   Solved: 2024/04/05 16:29:30 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/**
 * m과 n 입력받기
 * m이상 n이하의 자연수 중 소수 찾기
 * 소수들의 합 구하기
 * 소수들의 최솟값 구하기
 */
#include <bits/stdc++.h>
using namespace std;

vector<int> sieveOfEratosthenes(int m, int n)
{
    vector<bool> prime(n + 1, true);
    vector<int> primes;

    prime[0] = prime[1] = false;

    for (int i = 2; i * i < n; i++)
    {
        if (prime[i])
        {
            for (int j = i * i; j <= n; j += i)
            {
                prime[j] = false;
            }
        }
    }
    for (int i = m; i <= n; i++)
    {
        if (prime[i] == true)
        {
            primes.push_back(i);
        }
    }
    return primes;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int m, n;
    int sum = 0;
    int min_num = INT_MAX;
    cin >> m >> n; // m<=n
    vector<int> primes = sieveOfEratosthenes(m, n);

    if (primes.empty())
    {
        cout << "-1\n"; // 소수가 없는 경우
    }
    else
    {
        int sum = accumulate(primes.begin(), primes.end(), 0);
        cout << sum << "\n"
             << primes.front() << "\n"; // 소수들의 합과 최솟값 출력
    }
    return 0;
}