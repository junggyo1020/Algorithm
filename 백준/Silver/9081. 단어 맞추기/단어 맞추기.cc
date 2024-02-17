/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9081                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9081                           #+#        #+#      #+#    */
/*   Solved: 2024/02/18 01:39:48 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/**
 * 단어를 사전순으로 정렬하는 방법?
 * abc -> acb -> bac -> bca -> cab -> cba
 * 1. 이전 문자가 현재 문자보다 작은 위치 결정
 * 2. 그 위치보다 뒤에 있는 문자들 중 가장 작은 문자 찾음
 * 3. 그 위치에 있는 문자와 가장 작은 문자를 교환 후 사전 순 정렬
 */

#include <iostream>
#include <string>
#include <algorithm> // sort 함수 사용을 위해 추가
#define endl "\n"
using namespace std;

// 문자열 s를 참조로 받도록 수정하여 함수 내의 변경사항이 main 함수의 s에 반영되도록 함
bool nextString(string &s)
{
    int n = s.length(), i, j;

    // 1. 이전 문자가 현재 문자보다 작은 위치 찾기
    for (i = n - 2; i >= 0; i--)
    {
        if (s[i] < s[i + 1])
        {
            break;
        }
    }
    if (i < 0) // 순열 끝까지 탐색, 다음 순열이 없음
        return false;

    // 2. 교환할 더 큰 문자 찾기
    for (j = n - 1; j > i; j--)
    {
        if (s[i] < s[j])
        {
            break;
        }
    }

    // 3. 문자 교환
    swap(s[i], s[j]);
    // i+1부터 문자열의 끝까지 사전 순으로 정렬
    sort(s.begin() + i + 1, s.end());

    return true; // 성공적으로 다음 순열을 찾음
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; // 테스트 케이스 개수
    cin >> t;
    while (t--)
    {
        string s; // 입력받을 문자열(0<s.length()<=100)
        cin >> s;
        if (!nextString(s))
        { // 다음 순열이 없는 경우, 원본 문자열 그대로 출력
            // 이 경우는 사전 순으로 이미 마지막 순열이므로, 특별히 처리할 내용이 없습니다.
        }
        cout << s << endl; // 변경된 s 출력 (다음 순열 혹은 원본 문자열)
    }
}
