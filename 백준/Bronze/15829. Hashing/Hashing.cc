/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15829                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15829                          #+#        #+#      #+#    */
/*   Solved: 2024/03/03 16:46:58 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/**
 * 입력은 영문 소문자로만 이루어짐
 * a-z는 각각 1-26까지 고유번호로 부여
 * 문자열을 하나의 수열로 만들어야 한다.
 * 문자열의 각각 문자의 고유번호를 모두 더한 후 적당히 큰 수 M으로 나눠보자. -> 이 값이 해시 값
 * 하지만 이경우 문자열 순서만 바뀌어도 해쉬값의 충돌이 일어난다. -> 수정하자!
 * 각 항의 번호만큼 특정 숫자를 거듭제곱해서 곱해주도록 해쉬값을 지정해보자
 */

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

int L;
string s;
int idx;
int sum = 0;

void input()
{
    cin >> L >> s;
}

void doHash()
{
    for (int i = 0; i < L; i++)
    {
        idx = s[i] - 'a' + 1; // 고유번호 부여
        sum += idx * pow(31, i);
    }
    int result = sum % 1234567891;
    cout << result << endl;
}

int main()
{
    input();
    doHash();
}