/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4948                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4948                           #+#        #+#      #+#    */
/*   Solved: 2024/04/09 16:53:52 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
using namespace std;
void sieveOfEratosthenes(int &n)
{
    vector<bool> prime(2 * n + 1, true);
    vector<int> primes;
    prime[0] = prime[1] = false;
    for (int i = 2; i < 2 * n; i++)
    {
        if (prime[i])
        {
            for (int j = i * 2; j <= 2 * n; j += i)
            {
                prime[j] = false;
            }
        }
    }
    for (int i = n + 1; i <= 2 * n; i++)
    {
        if (prime[i])
        {
            primes.push_back(i);
        }
    }
    cout << primes.size() << "\n";
}

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0);
    int n;
    while (1)
    {
        cin >> n;
        if (n == 0)
            break;
        sieveOfEratosthenes(n);
    }
    return 0;
}