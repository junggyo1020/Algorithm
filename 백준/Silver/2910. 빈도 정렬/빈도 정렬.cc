#include <bits/stdc++.h>
using namespace std;
int n, c;
int a[1004];
map<int, int> mp, mp_first; // 숫자별 빈도수, 숫자별 등장하는 처음 인덱스 저장
vector<pair<int, int>> v;   // 빈도 정렬을 저장하기 위한 벡터
bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.first == b.first)
    {
        // 빈도수가 같은 경우 먼저 등장한 순으로 정렬
        return mp_first[a.second] < mp_first[b.second];
    }
    return a.first > b.first;
}
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin >> n >> c;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
        mp[a[i]]++; // 숫자가 등장할 때마다 빈도수를 증가
        if (mp_first[a[i]] == 0)
        {
            // 만약 해당 숫자가 처음 등장한 경우 인덱스값을 저장
            mp_first[a[i]] = i + 1;
        }
    }
    for (auto it : mp)
    {
        v.push_back({it.second, it.first}); //{빈도수, 숫자}
    }
    sort(v.begin(), v.end(), cmp); // 커스텀 정렬
    for (auto i : v)
    {
        // 빈도정렬한 수를 출력
        for (int j = 0; j < i.first; j++)
        {
            cout << i.second << ' ';
        }
    }
    return 0;
}