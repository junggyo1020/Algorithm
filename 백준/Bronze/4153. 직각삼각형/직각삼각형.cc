/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4153                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4153                           #+#        #+#      #+#    */
/*   Solved: 2024/03/03 12:50:21 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <cmath>
#include <algorithm>
#define endl "\n"
using namespace std;

int main()
{
    while (1)
    {
        int arr[3];
        for (int i = 0; i < 3; i++)
        {
            cin >> arr[i];
        }
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
        {
            break;
        }

        sort(arr, arr + 3);

        if (pow(arr[0], 2) + pow(arr[1], 2) == pow(arr[2], 2))
            cout << "right" << endl;
        else
            cout << "wrong" << endl;
    }
}