/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9996                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9996                           #+#        #+#      #+#    */
/*   Solved: 2024/03/17 18:05:47 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <bits/stdc++.h>
using namespace std;
string pattern, file;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int n;
    cin >> n >> pattern;
    // 패턴 나누기 '*' 기준으로
    int idx = pattern.find("*"); // 1 2 3 * 5 --> 3
    string front_str = pattern.substr(0, idx);
    string back_str = pattern.substr(idx + 1);
    // 파일 입력받기
    for (int i = 0; i < n; i++)
    {
        cin >> file;
        // 파일 이름의 길이가 패턴의 앞뒤 부분을 포함할 만큼 충분히 긴지 확인
        if (file.length() < front_str.length() + back_str.length())
        {
            cout << "NE" << '\n';
            continue;
        }
        // 패턴의 앞/뒤 부분과 파일이름의 앞부분이 같은지 확인 ab*b abccb
        if (file.substr(0, idx) == front_str && file.substr(file.length() - (back_str.length())) == back_str)
        {
            cout << "DA" << '\n';
        }
        else
        {
            cout << "NE" << '\n';
        }
    }
    return 0;
}