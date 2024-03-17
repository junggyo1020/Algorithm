/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2559                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2559                           #+#        #+#      #+#    */
/*   Solved: 2024/03/17 20:41:26 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int n, k;
    cin >> n >> k;
    vector<int> temp(n);
    for (int i = 0; i < n; i++)
    {
        cin >> temp[i];
    }
    // K개 씩 더한 값 배열에 저장
    int sum = 0;
    for (int i = 0; i < k; i++)
    {
        sum += temp[i];
    }
    // Max값 구하기
    int max_sum = sum;
    for (int i = k; i < n; i++)
    {
        sum += temp[i] - temp[i - k];
        max_sum = max(max_sum, sum);
    }
    cout << max_sum << '\n';
    return 0;
}