/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17298                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17298                          #+#        #+#      #+#    */
/*   Solved: 2024/08/18 23:35:07 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/*
 * 오큰수 구하기
 * 오큰수 : 어떤 수보다 크고 오른쪽에 있는 수들 중 가장 왼쪽에 있는 수
 * 범위 : n 1백만 , 시간 : 1초
 * -> 무식하게 구할 수 있는지? (완전탐색)
 * -> 일단 시도해보자 (1백만 * 1백만 = 대충 1000억)
 * -> 다른 방법 이용해야 함
 * -> 짝짓기 문제 = 스택으로 풀어보자
 */
#include <bits/stdc++.h>
using namespace std;
int n, a[1000004], ret[1000004];
stack<int> st;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n;
    memset(ret, -1, sizeof(ret));
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
        while (st.size() && a[st.top()] < a[i])
        {
            ret[st.top()] = a[i];
            st.pop();
        }
        st.push(i);
    }
    for (int i = 0; i < n; i++)
    {
        cout << ret[i] << " ";
    }
}