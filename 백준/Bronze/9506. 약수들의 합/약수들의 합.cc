/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9506                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9506                           #+#        #+#      #+#    */
/*   Solved: 2024/04/05 13:50:02 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/**
 * 무한루프 진행
 * 값을 입력받음
 * n이 -1일 경우 루프 종료
 * 약수 구하기 + sum 값 구하기
 * 완전수인지 확인(sum==n)
 */
#include <bits/stdc++.h>
using namespace std;

int n;

void find_measure(int &n)
{
    int sum = 0;
    vector<int> v;
    for (int i = 1; i <= n; i++)
    {
        if (n % i == 0)
        {
            v.push_back(i);
        }
    }
    for (int i : v)
    {
        if (i != n)
        {
            sum += i;
        }
    }
    if (sum == n)
    { // 완전수의 경우
        cout << n << " = ";
        for (int i = 0; i < v.size() - 2; i++)
        {
            cout << v[i] << " + ";
        }
        cout << v[v.size() - 2] << "\n";
    }
    else
    {
        cout << n << " is NOT perfect.\n";
    }
}

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    while (1)
    {
        cin >> n;
        if (n == -1)
        {
            break;
        }
        find_measure(n);
    }

    return 0;
}