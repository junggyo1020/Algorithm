/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2108                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2108                           #+#        #+#      #+#    */
/*   Solved: 2024/04/11 16:49:38 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <algorithm> // max_element
#include <vector>
#include <numeric> //accumulate
#include <cmath>   //반올림
#include <iomanip> // 반올림
#define endl "\n"
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }
    // 1. 산술평균
    double sum = accumulate(v.begin(), v.end(), 0.0);
    double avg = sum / n;
    avg = round(avg);
    // -0을 0으로 조정
    if (avg == -0.0)
    {
        avg = 0.0;
    }
    cout << avg << "\n";
    // 2. 중앙값
    sort(v.begin(), v.end());
    cout << v[n / 2] << endl;
    // 3. 최빈값
    // 빈도수를 저장하는 벡터 추가
    vector<int> freq(8001, 0);
    for (int num : v)
    {
        freq[num + 4000]++;
    }
    int max_freq = *max_element(freq.begin(), freq.end());
    // 최대 빈도수인 값을 모두 저장
    vector<int> modes;
    for (int i = 0; i < freq.size(); i++)
    {
        if (freq[i] == max_freq)
        {
            modes.push_back(i - 4000);
        }
    }
    sort(modes.begin(), modes.end());
    cout << (modes.size() > 1 ? modes[1] : modes[0]) << endl;
    // 4. 범위
    cout << v.back() - v.front() << "\n";

    return 0;
}