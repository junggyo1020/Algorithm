/**
 * 알파벳 개수 세기: 입력된 문자열에서 각 알파벳의 개수를 셉니다.
 * 팰린드롬 가능 여부 확인: 팰린드롬을 만들기 위해 홀수 개의 알파벳이 하나 이하인지 확인합니다.
 * 팰린드롬 구성: 가능하다면 사전 순으로 앞서는 팰린드롬을 만듭니다.
 */
#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;
int main()
{
    fastio;

    // 입력처리
    string name;
    cin >> name;

    // 알파벳 개수 세기
    vector<int> alpha(26, 0);
    for (char c : name)
    {
        alpha[c - 'A']++;
    }

    // 알파벳의 개수가 홀수인 경우 처리하기
    int odd_count = 0;
    char odd_char = 0;
    for (int i = 0; i < alpha.size(); i++)
    {
        if (alpha[i] % 2 != 0)
        {
            odd_count++;
            odd_char = 'A' + i;
        }
    }
    if (odd_count > 1)
    {
        cout << "I'm Sorry Hansoo" << endl;
        return 0;
    }

    // 새로운 이름 만들기(팰린드롬)
    string half = "";
    for (int i = 0; i < 26; i++)
    {
        half += string(alpha[i] / 2, 'A' + i);
    }
    string result = half;

    // 나머지 새로운 이름의 절반 채우기(reverse 함수 사용)
    reverse(half.begin(), half.end());
    if (odd_count == 1)
    {
        result += odd_char;
    }
    result += half;

    cout << result << endl;
    return 0;
}