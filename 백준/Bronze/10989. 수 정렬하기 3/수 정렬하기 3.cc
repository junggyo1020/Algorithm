/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10989                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10989                          #+#        #+#      #+#    */
/*   Solved: 2024/03/04 14:49:32 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
#define MAX 10001
using namespace std;

// counting sort를 해야합니다.
int main()
{
    fastio;
    int N, x;
    cin >> N;

    int count[MAX] = {0};

    // 빈도 값 저장
    for (int i = 0; i < N; i++)
    {
        cin >> x;
        count[x]++;
    }

    // 빈도값을 저장한 배열을 누적합 배열로 변경한다.
    for (int i = 1; i < MAX; i++)
    {
        for (int j = 0; j < count[i]; j++)
        {
            cout << i << endl;
        }
    }

    return 0;
}