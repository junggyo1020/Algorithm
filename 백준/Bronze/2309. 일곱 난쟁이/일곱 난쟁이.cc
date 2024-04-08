#include <bits/stdc++.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;
int height[9];
int sum = 0;
vector<int> v;
pair<int, int> ret;
void solve()
{
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (sum - height[i] - height[j] == 100)
            {
                ret = {i, j};
                return;
            }
        }
    }
}

int main()
{
    fastio;
    for (int i = 0; i < 9; i++)
    {
        cin >> height[i];
        sum += height[i];
    }
    solve();
    for (int i = 0; i < 9; i++)
    {
        if (ret.first == i || ret.second == i)
            continue;
        v.push_back(height[i]);
    }
    sort(v.begin(), v.end());
    for (int i : v)
    {
        cout << i << '\n';
    }
    return 0;
}