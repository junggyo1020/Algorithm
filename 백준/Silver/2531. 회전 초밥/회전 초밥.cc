/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2531                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2531                           #+#        #+#      #+#    */
/*   Solved: 2024/03/27 10:22:58 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int N, d, k, c;
    cin >> N >> d >> k >> c;
    vector<int> belt(N); // 초밥의 상태 체크
    for (int i = 0; i < N; i++)
    {
        cin >> belt[i];
    }
    unordered_map<int, int> sushiCount;      // 초밥 등장 횟수 <종류,개수>
    int kindOfSushi = 0, maxKindOfSushi = 0; // 초밥 종류의 개수
    sushiCount[c]++;
    kindOfSushi++;
    for (int i = 0; i < k; i++)
    {
        if (sushiCount[belt[i]]++ == 0) // 기존에 없는 번호의 스시를 찾을 경우
        {
            kindOfSushi++; // 초밥 종류의 개수 증가
        }
    }
    maxKindOfSushi = kindOfSushi;
    for (int s = 1; s <= N; s++)
    {
        int e = (s + k - 1) % N; // 모듈로 연산(원형이기 떄문!)
        if (--sushiCount[belt[s - 1]] == 0)
        { // 해당 스시가 더이상 남아있지 않을 때
            kindOfSushi--;
        }
        if (sushiCount[belt[e]]++ == 0)
        { // 끝부분으로 다른 종류의 스시가 들어왔을 때
            kindOfSushi++;
        }
        maxKindOfSushi = max(maxKindOfSushi, kindOfSushi);
    }
    cout << maxKindOfSushi << '\n';
    return 0;
}