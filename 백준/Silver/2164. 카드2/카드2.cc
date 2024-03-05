/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2164                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2164                           #+#        #+#      #+#    */
/*   Solved: 2024/03/05 14:02:52 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <algorithm> //swap
#include <queue>     //queue
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int main()
{
    fastio;
    int n;
    cin >> n;

    // 큐 선언
    queue<int> que;

    // 큐에 요소 추가하기
    for (int i = 1; i <= n; i++)
    {
        que.push(i);
    }

    // 요소가 한개 남을 때 까지 반복
    while (que.size() > 1)
    {
        // 요소 삭제하기
        que.pop();
        // 앞의 요소를 맨 뒤로 옮기기
        que.push(que.front());
        // 바꾼 후 맨앞 요소 삭제하기
        que.pop();
    }

    while (!que.empty())
    {
        cout << que.front();
        que.pop();
    }
}