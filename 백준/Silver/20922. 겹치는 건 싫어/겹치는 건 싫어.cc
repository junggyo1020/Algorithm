/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 20922                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/20922                          #+#        #+#      #+#    */
/*   Solved: 2024/03/13 21:57:56 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int n, k;
    cin >> n >> k;
    vector<int> vec(n);
    vector<int> arr(100001, 0); // 정수의 등장 횟수를 저장하는 배열

    for (int i = 0; i < n; i++)
    {
        cin >> vec[i];
    }

    int start = 0, end = 0, maxLength = 0;
    while (end < n)
    {
        if (arr[vec[end]] < k)
        {
            arr[vec[end]]++;
            end++;
        }
        else if (vec[start] == vec[end])
        {
            start++;
            end++;
        }
        else
        {
            arr[vec[start]]--;
            start++;
        }
        maxLength = max(maxLength, end - start);
    }

    cout << maxLength;
    return 0;
}
