/**
 * 재료 중 두개의 합이 M이 되는 경우의 수 구하기
 * 투포인터(정렬된 배열에서 특정한 값 m인 두 숫자를 찾기 위한 아이디어)
 */
#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;
int main()
{
    fastio;
    int n, m;
    cin >> n >> m;

    vector<int> num(n);
    for (int i = 0; i < n; i++)
    {
        cin >> num[i];
    }

    sort(num.begin(), num.end());

    int count = 0; // 두 숫자의 합이 m인 경우의 수
    int left = 0, right = n - 1;

    // 투 포인터
    while (left < right)
    {
        int sum = num[left] + num[right];
        if (sum == m)
        {
            count++;
            left++;
            right--;
        }
        else if (sum < m)
        {
            left++;
        }
        else
        {
            right--;
        }
    }
    cout << count << "\n";
    return 0;
}