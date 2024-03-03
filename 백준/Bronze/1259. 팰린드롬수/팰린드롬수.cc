/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1259                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1259                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 22:21:11 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

bool isPelindrome(string s)
{
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] != s[s.length() - i - 1])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    string s;
    while (1)
    {
        cin >> s;
        // 0을 입력받으면 종료
        if (s == "0")
        {
            break;
        }
        // 팰린드롬 검사
        if (isPelindrome(s))
        {
            cout << "yes" << endl;
        }
        else
        {
            cout << "no" << endl;
        }
    }
}