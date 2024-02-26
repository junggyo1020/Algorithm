/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1193                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1193                           #+#        #+#      #+#    */
/*   Solved: 2024/02/26 16:34:27 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
/**
 * 1/1 1/2 2/1 3/1 2/2 1/3 1/4 2/3 3/2 4/1
 */
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int x;
    bool check = true; // true : 홀, false : 짝
    int a = 1, b = 1;  // a : 분자, b : 분모
    cin >> x;

    /*
    대각선마다 읽는 순서가 달라짐, 짝수번째는 오른쪽에서 왼쪽, 홀수번째는 왼쪽에서 오른쪽
    이번줄이 홀수번째인지 짝수번째인지 구분하는 문자가 필요할듯 --> check
    */
    if (x == 1)
    {
        cout << a << '/' << b; // 1/1
        return 0;
    }
    for (int i = x - 1; i > 0; i--)
    {
        if (check == true)
        {
            if (a == 1)
            {
                check = !check;
                b++;
                continue;
            }
            a--;
            b++;
        }
        else
        {
            if (b == 1)
            {
                check = !check;
                a++;
                continue;
            }
            a++;
            b--;
        }
    }

    cout << a << '/' << b;
    return 0;
}